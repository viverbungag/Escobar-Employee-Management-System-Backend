package com.exe.EMS.EmployeeAttendanceJoin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeAttendanceJoin_mysql")
public interface EmployeeAttendanceJoinMySqlRepository extends EmployeeAttendanceJoinDao, JpaRepository<EmployeeAttendanceJoin, Long> {

    @Query(value = "SELECT * FROM #{#entityName}",
        nativeQuery = true)
    List<EmployeeAttendanceJoin> getAllAttendance();

    @Query(value = "SELECT * FROM #{#entityName} WHERE employee_id = :employeeId",
            nativeQuery = true)
    List<EmployeeAttendanceJoin> getAllAttendanceBasedOnEmployeeId(@Param("employeeId") Long employeeId);
}
