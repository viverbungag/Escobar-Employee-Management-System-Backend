package com.exe.EMS.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login")
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @PostMapping("/employee")
    public AccountLoginDto loginEmployee(@RequestBody AccountLoginDto accountLoginDto){
        return securityService.loginEmployee(accountLoginDto);
    }

    @PostMapping("/admin")
    public AccountLoginDto loginAdmin(@RequestBody AccountLoginDto accountLoginDto){
        return securityService.loginAdmin(accountLoginDto);
    }
}
