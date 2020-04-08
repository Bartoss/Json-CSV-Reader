package service;

import model.Employee;

import java.util.HashMap;
import java.util.List;

public interface CalculateSalary {
    HashMap<String, Float> calculations(List<Employee> employeeArrayList);
}
