package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Attendance extends Model {
    public int attendance_id;
    public Boolean attendance_status;
    public String attendance_date;
    public int attendance_student_id;
    public int attendance_section_session;
    public String attendance_comment;
    public int attendance_section_id;

    public Attendance(){
        attendance_id= 0;
        attendance_status=false;
        attendance_date="";
        attendance_student_id=0;
        attendance_section_session=0;
        attendance_comment="";
        attendance_section_id=0;
    }

    public Attendance(int attendance_id, Boolean attendance_status,
                      String attendance_date, int attendance_student_id,
                      int attendance_section_session, String attendance_comment,
                      int attendance_section_id) {
        this.attendance_id = attendance_id;
        this.attendance_status = attendance_status;
        this.attendance_date = attendance_date;
        this.attendance_student_id = attendance_student_id;
        this.attendance_section_session = attendance_section_session;
        this.attendance_comment = attendance_comment;
        this.attendance_section_id = attendance_section_id;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public Boolean getAttendance_status() {
        return attendance_status;
    }

    public void setAttendance_status(Boolean attendance_status) {
        this.attendance_status = attendance_status;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }

    public int getAttendance_student_id() {
        return attendance_student_id;
    }

    public void setAttendance_student_id(int attendance_student_id) {
        this.attendance_student_id = attendance_student_id;
    }

    public int getAttendance_section_session() {
        return attendance_section_session;
    }

    public void setAttendance_section_session(int attendance_section_session) {
        this.attendance_section_session = attendance_section_session;
    }

    public String getAttendance_comment() {
        return attendance_comment;
    }

    public void setAttendance_comment(String attendance_comment) {
        this.attendance_comment = attendance_comment;
    }

    public int getAttendance_section_id() {
        return attendance_section_id;
    }

    public void setAttendance_section_id(int attendance_section_id) {
        this.attendance_section_id = attendance_section_id;
    }
}

