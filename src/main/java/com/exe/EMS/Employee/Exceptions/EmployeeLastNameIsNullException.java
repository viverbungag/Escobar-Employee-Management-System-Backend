package com.exe.EMS.Employee.Exceptions;

public class EmployeeLastNameIsNullException extends RuntimeException{

    public EmployeeLastNameIsNullException(){
        super("Employee last field should not be empty");
    }
}
