package service;

import model.Employee;
import org.junit.Test;
import service.impl.ReaderCsvImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testFormatReaderImpl {
    private final static String pathCsv = "files/employees.csv";
    private List<Employee> employeeArrayList = new ArrayList<>();
    private ReaderCsvImpl readerCsvImpl = new ReaderCsvImpl();

    @Test
    public void testReadCSV() {
        Employee employee = new Employee();
        employee.setSurname("Green");
        employee.setId(1);
        employee.setName("Mark");
        employee.setJob("Teacher");

        employeeArrayList = readerCsvImpl.readFormat(pathCsv);

        assertEquals(employee.getName(), employeeArrayList.get(0).getName());

    }
}
