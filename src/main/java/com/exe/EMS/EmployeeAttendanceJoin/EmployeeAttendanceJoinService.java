package com.exe.EMS.EmployeeAttendanceJoin;

import com.exe.EMS.Employee.Employee;
import com.exe.EMS.Employee.EmployeeDao;
import com.exe.EMS.Employee.Exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeAttendanceJoinService {

    @Autowired
    @Qualifier("employeeAttendanceJoin_mysql")
    EmployeeAttendanceJoinDao employeeAttendanceJoinRepository;

    @Autowired
    @Qualifier("employee_mysql")
    EmployeeDao employeeRepository;

    private EmployeeAttendanceJoinDto convertEntityToDto(EmployeeAttendanceJoin employeeAttendanceJoin){
        return new EmployeeAttendanceJoinDto(
                employeeAttendanceJoin.getEmployeeAttendanceJoinId(),
                String.format("%s, %s", employeeAttendanceJoin.getEmployee().getEmployeeLastName(), employeeAttendanceJoin.getEmployee().getEmployeeFirstName()),
                employeeAttendanceJoin.getEmployeeAttendance().getAttendanceTime(),
                employeeAttendanceJoin.getEmployeeAttendance().getAttendanceType()
        );
    }

    public List<EmployeeAttendanceJoinDto> getAllAttendance(){
        return employeeAttendanceJoinRepository
                .getAllAttendance()
                .stream()
                .map((attendance) -> convertEntityToDto(attendance))
                .collect(Collectors.toList());
    }

    public List<EmployeeAttendanceJoinDto> getAllAttendanceBasedOnEmployeeId(String employeeName){
        String[] employeeSplit = employeeName.split(", ");
        String employeeLastName = employeeSplit[0];
        String employeeFirstName = employeeSplit[1];

        Employee employee = employeeRepository
                .getEmployeeByFirstAndLastName(employeeFirstName, employeeLastName)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(employeeFirstName, employeeLastName));

        return employeeAttendanceJoinRepository
                .getAllAttendanceBasedOnEmployeeId(employee.getEmployeeId())
                .stream()
                .map((attendance) -> convertEntityToDto(attendance))
                .collect(Collectors.toList());
    }
}
