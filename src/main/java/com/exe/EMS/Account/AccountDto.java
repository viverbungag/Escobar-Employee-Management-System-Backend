package com.exe.EMS.Account;

import com.exe.EMS.Employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@Getter
@Setter
public class AccountDto {

    private Long accountId;
    private String accountUsername;
    private String accountPassword;
    private String employeeName;
    private Boolean accessInventoryManagementSystem;
    private Boolean accessEmployeeManagementSystem;
    private Boolean accessIncomeAndExpenseSystem;
    private Boolean accessOrderingSystem;
    private Boolean isActive;
}
