package com.exe.EMS.Employee;


import com.exe.EMS.EmployeePosition.EmployeePosition;
import com.exe.EMS.EmployeeType.EmployeeType;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @NonNull
    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @NonNull
    @Column(name = "employee_last_name")
    private String employeeLastName;

    @NonNull
    @Column(name = "employee_address")
    private String employeeAddress;

    @NonNull
    @Column(name = "employee_contact_number")
    private String employeeContactNumber;

    @NonNull
    @Column(name = "employee_date_employed")
    private LocalDateTime dateEmployed;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "employee_position_id")
    private EmployeePosition employeePosition;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "superior_employee_id")
    private Employee superiorEmployee;
}
