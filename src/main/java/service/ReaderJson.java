package service;

import model.Employee;

import java.util.List;

public interface ReaderJson {
    List<Employee> readJSON(String pathToFile);
}
