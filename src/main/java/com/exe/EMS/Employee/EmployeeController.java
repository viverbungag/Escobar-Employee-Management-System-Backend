package com.exe.EMS.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/active")
    public List<EmployeeDto> getAllActiveEmployees(){
        return employeeService.getAllActiveEmployees();
    }

    @GetMapping("/inactive")
    public List<EmployeeDto> getAllInactiveEmployees(){
        return employeeService.getAllInactiveEmployees();
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.addEmployee(employeeDto);
    }


}
