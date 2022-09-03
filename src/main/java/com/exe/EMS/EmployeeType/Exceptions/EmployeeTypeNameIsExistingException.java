package com.exe.EMS.EmployeeType.Exceptions;

public class EmployeeTypeNameIsExistingException extends RuntimeException{

    public EmployeeTypeNameIsExistingException(String name){
        super(String.format("The Name %s is already existing", name));
    }
}
