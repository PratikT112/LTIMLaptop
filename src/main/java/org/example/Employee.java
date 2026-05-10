package org.example;

public class Employee {

    private int employeeId;
    private String role;

    public Employee(int employeeId, String role) {
        this.employeeId = employeeId;
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(employeeId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Employee that = (Employee) obj;
        return employeeId == that.employeeId;
    }
}
