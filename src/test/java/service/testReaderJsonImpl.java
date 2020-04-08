package service;

import model.Employee;
import org.junit.Test;
import service.impl.ReaderJsonImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testReaderJsonImpl {

    private final static String pathJson = "files/employees.json";

    private List<Employee> employeeArrayList = new ArrayList<>();
    private ReaderJsonImpl readerJsonImpl = new ReaderJsonImpl();

    @Test
    public void testReadJSON() {
        Employee employee = new Employee();
        employee.setSurname("Green");
        employee.setId(1);
        employee.setName("Mark");
        employee.setJob("Teacher");

        employeeArrayList = readerJsonImpl.readJSON(pathJson);

        assertEquals(employee.getName(), employeeArrayList.get(0).getName());

    }
}
