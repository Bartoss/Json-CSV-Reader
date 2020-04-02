package service;

import model.Employee;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CalculateSalaryTest {

    @Test
    public void testCalculations() throws Exception{
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        CalculateSalary calculateSalary = new CalculateSalary();
        HashMap<String, Float> salaryMap;

        Employee driver1 = new Employee();
        driver1.setId(1);
        driver1.setJob("Driver");
        driver1.setSalary("1289.99");
        employeeArrayList.add(driver1);

        Employee driver2 = new Employee();
        driver2.setId(2);
        driver2.setJob("Driver");
        driver2.setSalary("1489.99");
        employeeArrayList.add(driver2);

        Employee chef = new Employee();
        chef.setId(3);
        chef.setJob("Chef");
        chef.setSalary("1379.02");
        employeeArrayList.add(chef);

        salaryMap = calculateSalary.calculations(employeeArrayList);

        ///////////////////////////////////////////////////////////////////
        float value = salaryMap.get(chef.getJob());
        float salary = Float.parseFloat(chef.getSalary());

        assertTrue(Math.abs(value-salary) == 0);

        ///////////////////////////////////////////////////////////////////
        value = salaryMap.get(driver1.getJob());
        salary = (float) 2779.98;
        assertTrue(Math.abs(value-salary) == 0);
    }
}
