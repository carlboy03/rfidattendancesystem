package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Course extends Model {
    public int course_id;
    public String course_code;
    public String course_name;


    public Course() {
        int course_id=0;
        String course_code="";
        String course_name="";


    }

    public Course(int course_id,
            String course_code,
            String course_name

    ){
        this.course_id=course_id;
        this.course_code=course_code;
        this.course_name=course_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}

