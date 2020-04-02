package service;

import model.Employee;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testReaderJSON {

    private final static String pathJson = "/Users/bartekMacBookPro/Documents/Json-CSV-Reader/src/main/resources/files/employees.json";

    private ArrayList<Employee> employeeArrayList = new ArrayList<>();
    private ReaderJSON readerJSON = new ReaderJSON();

    @Test
    public void testReadJSON(){
        Employee employee = new Employee();
        employee.setSurname("Green");
        employee.setId(1);
        employee.setName("Mark");
        employee.setJob("Teacher");

        employeeArrayList = readerJSON.readJSON(pathJson);

        assertEquals(employee.getName(), employeeArrayList.get(0).getName());

    }
}
