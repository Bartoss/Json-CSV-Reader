package service;

import model.Employee;

import java.util.List;

public interface ReaderCsv {
    List<Employee> readCSV(String pathToFile);
}
