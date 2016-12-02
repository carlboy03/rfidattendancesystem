package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;


public class Section extends Model {
    public int section_id;
    public String section_name;
    public int course_id;
    public String section_term;
    public String professor_id;


    public Section() {
        int section_id;
        String section_name;
        int course_id;
        String section_term;
        String professor_id;
    }

    public Section(int section_id,
                   String section_name,
                   int course_id,
                   String section_term,
                   String professor_id) {
        this.section_id = section_id;
        this.section_name = section_name;
        this.course_id = course_id;
        this.section_term = section_term;
        this.professor_id = professor_id;

    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getSection_term() {
        return section_term;
    }

    public void setSection_term(String section_term) {
        this.section_term = section_term;
    }

    public String getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }
}

