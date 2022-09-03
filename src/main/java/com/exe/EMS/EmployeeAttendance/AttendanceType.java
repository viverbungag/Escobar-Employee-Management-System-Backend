package com.exe.EMS.EmployeeAttendance;

public enum AttendanceType {
    CHECK_IN("CHECK IN"),
    CHECK_OUT("CHECK OUT");

    private final String string;

    AttendanceType(final String string){
        this.string = string;
    }

    @Override
    public String toString(){
        return string;
    }
}
