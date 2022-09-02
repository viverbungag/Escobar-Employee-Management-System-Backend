package com.exe.EMS.EmployeePosition.Exceptions;

public class EmployeePositionNameIsExistingException extends RuntimeException {

    public EmployeePositionNameIsExistingException(String name){
        super(String.format("The Name %s is already existing", name));
    }
}
