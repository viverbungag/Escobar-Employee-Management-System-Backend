package com.exe.EMS.EmployeePosition;

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
public class EmployeePositionDto {

    private Long employeePositionId;
    private String employeePositionName;
    private Boolean isActive;
}
