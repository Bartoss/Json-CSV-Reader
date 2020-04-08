package service;

import model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testReaderCSV {
    private final static String pathCsv = "files/employees.csv";
    private List<Employee> employeeArrayList = new ArrayList<>();
    private ReaderCSV readerCSV = new ReaderCSV();
    @Test
    public void testReadCSV(){
        Employee employee = new Employee();
        employee.setSurname("Green");
        employee.setId(1);
        employee.setName("Mark");
        employee.setJob("Teacher");

        employeeArrayList = readerCSV.readCSV(pathCsv);

        assertEquals(employee.getName(), employeeArrayList.get(0).getName());

    }
}
