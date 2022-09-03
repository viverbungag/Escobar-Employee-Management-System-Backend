package com.exe.EMS.Employee;

import com.exe.EMS.EmployeePosition.EmployeePosition;
import com.exe.EMS.EmployeeType.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto {

    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeAddress;
    private String employeeContactNumber;
    private LocalDateTime dateEmployed;
    private String employeePositionName;
    private String employeeTypeName;
    private String superiorEmployeeName;
    private Boolean isActive;
}
