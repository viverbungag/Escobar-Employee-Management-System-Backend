package com.exe.EMS.Security;
import com.exe.EMS.Account.Account;
import com.exe.EMS.Security.Exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SecurityService {

    @Autowired
    @Qualifier("security_mysql")
    SecurityDao securityRepository;

    private AccountLoginDto convertEntityToDto(Account account){
        return new AccountLoginDto(
                account.getAccountId(),
                account.getAccountUsername(),
                account.getAccountPassword(),
                String.format("%s, %s",account.getEmployee().getEmployeeLastName(), account.getEmployee().getEmployeeFirstName()),
                account.getAccessInventoryManagementSystem(),
                account.getAccessEmployeeManagementSystem(),
                account.getAccessIncomeAndExpenseSystem(),
                account.getAccessOrderingSystem(),
                account.getIsActive()
        );
    }

    public AccountLoginDto loginEmployee (AccountLoginDto accountLoginDto){

        Account account = securityRepository
                .findEmployeeUserByNameAndPassword(accountLoginDto.getAccountUsername(), accountLoginDto.getAccountPassword())
                .orElseThrow(() -> new UserDoesNotExistException());

        return convertEntityToDto(account);

    }

    public AccountLoginDto loginAdmin (AccountLoginDto accountLoginDto){

        Account account = securityRepository
                .findAdminUserByNameAndPassword(accountLoginDto.getAccountUsername(), accountLoginDto.getAccountPassword())
                .orElseThrow(() -> new UserDoesNotExistException());

        return convertEntityToDto(account);

    }
}
