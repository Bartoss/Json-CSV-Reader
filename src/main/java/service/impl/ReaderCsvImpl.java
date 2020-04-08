package service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Employee;
import service.ReaderCsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReaderCsvImpl implements ReaderCsv {

    private ArrayList<Employee> employeeArrayList = new ArrayList<>();
    private BufferedReader bufferedReader = null;

    public List<Employee> readCSV(String pathToFile) {

        try {
            bufferedReader = new BufferedReader(new FileReader(pathToFile));
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder(bufferedReader).withType(Employee.class).withIgnoreLeadingWhiteSpace(true).withSeparator(';').build();
            Iterator<Employee> csvEmployeeIterator = csvToBean.iterator();

            while (csvEmployeeIterator.hasNext()) {
                csvEmployeeIterator.forEachRemaining(person -> {
                    Employee employee = new Employee();
                    employee.setSurname(person.getSurname().replaceAll("\"", "").trim());
                    employee.setId(person.getId());
                    employee.setName(person.getName().replaceAll("\"", "").trim());
                    employee.setJob(person.getJob().replaceAll("\"", "").trim());
                    String salary = person.getSalary().replaceAll("\"", "");
                    employee.setSalary(salary.replaceAll(",", "."));
                    employeeArrayList.add(employee);
                });
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(ReaderCsvImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return employeeArrayList;
    }
}