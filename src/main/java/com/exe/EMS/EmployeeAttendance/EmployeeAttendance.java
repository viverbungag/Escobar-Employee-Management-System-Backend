package com.exe.EMS.EmployeeAttendance;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "employee_attendance")
public class EmployeeAttendance {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_attendance_id")
    private Long employeeAttendanceId;

    @NonNull
    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @NonNull
    @Column(name = "check_out")
    private LocalDateTime checkOut;

}
