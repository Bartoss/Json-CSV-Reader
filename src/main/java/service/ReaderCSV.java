package service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import model.Employee;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReaderCSV {

    private static final String SAMPLE_CSV_FILE_PATH = "/Users/bartekMacBookPro/Downloads/Java-JSON-CSV-Reader/src/main/resources/employees.csv";
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ArrayList<Employee> readCSV(){
        try
                (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)))
        {
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder(reader).withType(Employee.class).withIgnoreLeadingWhiteSpace(true).withSeparator(';').build();
            Iterator<Employee> csvEmployeeIterator = csvToBean.iterator();

            while(csvEmployeeIterator.hasNext()){
                csvEmployeeIterator.forEachRemaining(person ->{
                    Employee employee = new Employee();
                    employee.setSurname(person.getSurname().replaceAll("\"", ""));
                    employee.setId(person.getId());
                    employee.setName(person.getSurname().replaceAll("\"", ""));
                    employee.setJob(person.getJob().replaceAll("\"", ""));
                    employee.setSalary(person.getSalary().replaceAll("\"", ""));
                    employeeArrayList.add(employee);
                });
            }
        } catch (IOException e) {
            Logger.getLogger(ReaderCSV.class.getName()).log(Level.SEVERE, null, e);
        }
        return employeeArrayList;
    }
}