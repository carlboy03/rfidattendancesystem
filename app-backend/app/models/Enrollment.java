package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Enrollment extends Model {
    public int enrollment_id;
    public String enrollment_student_id;
    public String enrollment_section_id;


    public Enrollment() {
        int enrollment_id=0;
        String enrollment_student_id="";
        String enrollment_section_id="";

    }

    public Enrollment(int enrollment_id,
            String enrollment_student_id,
            String enrollment_section_id

    ){
        this.enrollment_id=enrollment_id;
        this.enrollment_student_id=enrollment_student_id;
        this.enrollment_section_id=enrollment_section_id;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public String getEnrollment_student_id() {
        return enrollment_student_id;
    }

    public void setEnrollment_student_id(String enrollment_student_id) {
        this.enrollment_student_id = enrollment_student_id;
    }

    public String getEnrollment_section_id() {
        return enrollment_section_id;
    }

    public void setEnrollment_section_id(String enrollment_section_id) {
        this.enrollment_section_id = enrollment_section_id;
    }
}

