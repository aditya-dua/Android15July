package com.adityadua.dbsqliteexamplesession15.model;

/**
 * Created by AdityaDua on 02/09/17.
 */

public class Employee {

    private int employeeID;
    private String employeeName;
    private String mobileNumber;
    private int salary;


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
