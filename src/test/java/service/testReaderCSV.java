package service;

import model.Employee;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class testReaderCSV {
    private final static String pathCsv = "/Users/bartekMacBookPro/Documents/Json-CSV-Reader/src/main/resources/files/employees.csv";
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();
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
