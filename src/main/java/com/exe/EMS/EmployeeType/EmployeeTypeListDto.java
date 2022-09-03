package com.exe.EMS.EmployeeType;

import com.exe.EMS.EmployeePosition.EmployeePositionDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class EmployeeTypeListDto {

    List<EmployeeTypeDto> employeeTypeListDto;
}
