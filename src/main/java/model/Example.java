package model;

import java.util.List;
import java.util.Objects;

public class Example {

    private List<Employee> employees = null;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Example)) return false;
        Example example = (Example) o;
        return Objects.equals(getEmployees(), example.getEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployees());
    }
}
