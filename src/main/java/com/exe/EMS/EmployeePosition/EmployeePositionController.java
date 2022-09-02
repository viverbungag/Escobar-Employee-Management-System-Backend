package com.exe.EMS.EmployeePosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee-position")
public class EmployeePositionController {

    @Autowired
    EmployeePositionService supplyCategoryService;

    @GetMapping
    public List<String> getAllActiveEmployeePositionNames(){
        return supplyCategoryService.getAllActiveEmployeePositionNames();
    }

    @GetMapping("/active")
    public List<EmployeePositionDto> getAllActiveEmployeePositions(){
        return supplyCategoryService.getAllActiveEmployeePositions();
    }

    @GetMapping("/inactive")
    public List<EmployeePositionDto> getAllInactiveEmployeePositions(){
        return supplyCategoryService.getAllInactiveEmployeePositions();
    }

    @PostMapping("/activate")
    public void activateEmployeePosition(@RequestBody EmployeePositionListDto supplyCategoryListDto){
        supplyCategoryService.activateEmployeePosition(supplyCategoryListDto);
    }

    @PostMapping("/inactivate")
    public void inactivateEmployeePosition(@RequestBody EmployeePositionListDto supplyCategoryListDto){
        supplyCategoryService.inactivateEmployeePosition(supplyCategoryListDto);
    }

    @PostMapping("/add")
    public void addEmployeePosition(@RequestBody EmployeePositionDto supplyCategoryDto){
        supplyCategoryService.addEmployeePosition(supplyCategoryDto);
    }

    @PutMapping("/update/{id}")
    public void updateEmployeePosition(@RequestBody EmployeePositionDto supplyCategoryDto, @PathVariable Long id){
        supplyCategoryService.updateEmployeePosition(supplyCategoryDto, id);
    }
}
