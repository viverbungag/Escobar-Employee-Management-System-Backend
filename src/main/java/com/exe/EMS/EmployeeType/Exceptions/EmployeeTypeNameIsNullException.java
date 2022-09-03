package com.exe.EMS.EmployeeType.Exceptions;

public class EmployeeTypeNameIsNullException extends RuntimeException {

    public EmployeeTypeNameIsNullException(){
        super("Type Name should not be empty");
    }
}
