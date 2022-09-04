package com.exe.EMS.Security.Exceptions;

public class UserDoesNotExistException extends RuntimeException{

    public UserDoesNotExistException(){
        super("The user does not exist");
    }
}
