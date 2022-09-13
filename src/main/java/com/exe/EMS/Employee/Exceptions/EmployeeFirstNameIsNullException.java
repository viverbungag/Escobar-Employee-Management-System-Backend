package com.exe.EMS.Employee.Exceptions;

public class EmployeeFirstNameIsNullException extends RuntimeException{

    public EmployeeFirstNameIsNullException(){
        super("Employee first field should not be empty");
    }
}
