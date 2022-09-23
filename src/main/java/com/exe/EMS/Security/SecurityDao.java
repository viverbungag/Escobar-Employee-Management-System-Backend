package com.exe.EMS.Security;

import com.exe.EMS.Account.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityDao {

    Optional<Account> findEmployeeUserByNameAndPassword(String accountUsername, String accountPassword);
    Optional<Account> findAdminUserByNameAndPassword(String accountUsername, String accountPassword);
}
