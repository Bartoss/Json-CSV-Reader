package service;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Employee;
import model.Example;

public class ReaderJSON {
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();
    public ArrayList<Employee> readJSON(String pathToFile) {
        try {
            Gson gson = new GsonBuilder().create();
            Example ourClass = null;
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
            Logger.getLogger(ReaderJSON.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return employeeArrayList;
    }
}
