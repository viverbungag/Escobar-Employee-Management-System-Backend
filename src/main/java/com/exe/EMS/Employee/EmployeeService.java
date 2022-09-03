package com.exe.EMS.Employee;

import com.exe.EMS.Employee.Exceptions.EmployeeNotFoundException;
import com.exe.EMS.EmployeePosition.EmployeePosition;
import com.exe.EMS.EmployeePosition.EmployeePositionDao;
import com.exe.EMS.EmployeePosition.Exceptions.EmployeePositionNotFoundException;
import com.exe.EMS.EmployeeType.EmployeeType;
import com.exe.EMS.EmployeeType.EmployeeTypeDao;
import com.exe.EMS.EmployeeType.Exceptions.EmployeeTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    @Qualifier("employee_mysql")
    EmployeeDao employeeRepository;

    @Autowired
    @Qualifier("employeePosition_mysql")
    EmployeePositionDao employeePositionRepository;

    @Autowired
    @Qualifier("employeeType_mysql")
    EmployeeTypeDao employeeTypeRepository;

    private EmployeeDto convertEntityToDto(Employee employee){
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getEmployeeFirstName(),
                employee.getEmployeeLastName(),
                employee.getEmployeeAddress(),
                employee.getEmployeeContactNumber(),
                employee.getDateEmployed(),
                employee.getEmployeePosition().getEmployeePositionName(),
                employee.getEmployeeType().getEmployeeTypeName(),
                employee.getSuperiorEmployee() != null ? String.format("%s, %s",employee.getSuperiorEmployee().getEmployeeLastName(), employee.getSuperiorEmployee().getEmployeeFirstName()): null,
                employee.getIsActive()
        );
    }

    public List<EmployeeDto> getAllActiveEmployees(){
        List<EmployeeDto> employees = employeeRepository
                .getAllActiveEmployees()
                .stream()
                .map((employee) -> convertEntityToDto(employee))
                .collect(Collectors.toList());

        return employees;
    }

    public List<EmployeeDto> getAllInactiveEmployees(){
        List<EmployeeDto> employees = employeeRepository
                .getAllInactiveEmployees()
                .stream()
                .map((employee) -> convertEntityToDto(employee))
                .collect(Collectors.toList());

        return employees;
    }

    public void addEmployee(EmployeeDto employeeDto){
        String firstName = employeeDto.getEmployeeFirstName();
        String lastName = employeeDto.getEmployeeLastName();
        String address = employeeDto.getEmployeeAddress();
        String contactNumber = employeeDto.getEmployeeContactNumber();
        LocalDateTime dateEmployed = employeeDto.getDateEmployed();
        EmployeePosition employeePosition = employeePositionRepository
                .getEmployeePositionByName(employeeDto.getEmployeePositionName())
                .orElseThrow(() -> new EmployeePositionNotFoundException(employeeDto.getEmployeePositionName()));

        EmployeeType employeeType = employeeTypeRepository.getEmployeeTypeByName(employeeDto.getEmployeeTypeName())
                        .orElseThrow(() -> new EmployeeTypeNotFoundException(employeeDto.getEmployeeTypeName()));

        Employee superior = employeeRepository.getEmployeeByFirstAndLastName(firstName, lastName)
                        .orElseThrow(() -> new EmployeeNotFoundException(firstName, lastName));

        Boolean isActive = employeeDto.getIsActive();



        employeeRepository.insertEmployees(firstName,
                lastName,
                address,
                contactNumber,
                dateEmployed,
                employeePosition.getEmployeePositionId(),
                employeeType.getEmployeeTypeId(),
                superior.getEmployeeId(),
                isActive);
    }
}
