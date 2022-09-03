package com.exe.EMS.EmployeeAttendanceJoin;


import com.exe.EMS.Employee.Employee;
import com.exe.EMS.EmployeeAttendance.EmployeeAttendance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity(name = "employee_attendance_join")
public class EmployeeAttendanceJoin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_attendance_join_id")
    private Long employeeAttendanceJoinId;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "employee_attendance_id")
    private EmployeeAttendance employeeAttendance;

}
