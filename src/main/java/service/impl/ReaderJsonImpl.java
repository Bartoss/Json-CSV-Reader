package service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Employee;
import model.Example;
import service.ReaderJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderJsonImpl implements ReaderJson {
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public List<Employee> readJSON(String pathToFile) {
        try {
            Gson gson = new GsonBuilder().create();
            Example ourClass;
            ourClass = gson.fromJson(new FileReader(pathToFile), Example.class);

            ourClass.getEmployees().forEach(person -> {
                Employee employee = new Employee();
                employee.setSurname(person.getSurname());
                employee.setId(person.getId());
                employee.setName(person.getName());
                employee.setJob(person.getJob());
                employee.setSalary(person.getSalary().replaceAll(",","."));
                employeeArrayList.add(employee);
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderJsonImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeeArrayList;
    }
}
