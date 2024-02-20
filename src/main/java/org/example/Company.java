package org.example;/*
  @author   user
  @project   lab3
  @class  Company
  @version  1.0.0 
  @since 20.02.2024 - 20.36
*/

public class Company {
    // parent for this company nullable, when there is no parent for this company
    private final Company parent;
    private final long employeesCount;

    public Company(Company parent, long employeesCount) {
        this.parent = parent;
        this.employeesCount = employeesCount;
    }

    public Company getParent() {
        return parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }
}
