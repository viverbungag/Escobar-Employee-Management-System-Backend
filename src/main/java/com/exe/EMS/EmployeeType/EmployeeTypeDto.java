package com.exe.EMS.EmployeeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeTypeDto {

    private Long employeeTypeId;
    private String employeeTypeName;
    private Boolean isActive;
}
