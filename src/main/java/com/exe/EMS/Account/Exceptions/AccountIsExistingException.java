package com.exe.EMS.Account.Exceptions;

public class AccountIsExistingException extends RuntimeException{

    public AccountIsExistingException(String username){
        super(String.format("The username %s is already existing", username));
    }

}
