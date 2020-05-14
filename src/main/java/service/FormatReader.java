package service;

import model.Employee;

import java.util.List;

public interface FormatReader {
    List<Employee> readFormat(String pathToFile);
}
