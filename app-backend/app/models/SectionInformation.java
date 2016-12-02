package models;

import com.avaje.ebean.*;


public class SectionInformation extends Model{
    Person person;
    Section section;
    Course course;


    public SectionInformation(Person person, Section section, Course course) {
        this.person = person;
        this.section = section;
        this.course = course;
    }
    public SectionInformation() {
        this.person = new Person();
        this.section = new Section();
        this.course = new Course();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
