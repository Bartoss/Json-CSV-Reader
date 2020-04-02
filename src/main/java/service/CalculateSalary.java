package service;

import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculateSalary {

    public static void calculations(ArrayList<Employee> employeeArrayList){
        ArrayList<Employee> employees;
        employees = employeeArrayList;
        HashMap<String, Float> salaryMap = new HashMap<>();
        employees.forEach(employee -> {
            float salary;
            salary = Float.parseFloat(employee.getSalary());
            if(salaryMap.containsKey(employee.getJob())){
                float tmp = salaryMap.get(employee.getJob());
                tmp += salary;
                salaryMap.replace(employee.getJob(),tmp);
            }else {
                salaryMap.put(employee.getJob(),salary);
            }

        });
        salaryMap.forEach((k,v) ->{
            System.out.println("k: " + k + " v:" + v);
        });

    }
}
