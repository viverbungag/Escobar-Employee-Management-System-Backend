package com.exe.EMS.Security;

import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountLoginDto {

    private String accountUsername;
    private String accountPassword;
    private String employeeName;
    private Boolean accessInventoryManagementSystem;
    private Boolean accessEmployeeManagementSystem;
    private Boolean accessIncomeAndExpenseSystem;
    private Boolean accessOrderingSystem;
}
