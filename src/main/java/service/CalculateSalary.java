package service;

import model.Employee;

import java.util.HashMap;
import java.util.List;

public class CalculateSalary {

    public HashMap<String, Float> calculations(List<Employee> employeeArrayList) {
        List<Employee> employees;
        employees = employeeArrayList;
        HashMap<String, Float> salaryMap = new HashMap<>();
        employees.forEach(employee -> {
            float tmp;
            tmp = Float.parseFloat(employee.getSalary());
            if (salaryMap.containsKey(employee.getJob())) {
                float salary = salaryMap.get(employee.getJob());
                salary += tmp;
                salaryMap.replace(employee.getJob(), salary);
            } else {
                salaryMap.put(employee.getJob(), tmp);
            }

        });
        return salaryMap;
    }
}
