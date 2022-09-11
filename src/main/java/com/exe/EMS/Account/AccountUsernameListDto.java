package com.exe.EMS.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AccountUsernameListDto {

    List<String> accountUsernames;
}
