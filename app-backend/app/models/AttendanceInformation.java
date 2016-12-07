package models;

import com.avaje.ebean.*;


public class AttendanceInformation extends Model{
    Person person;
    Attendance attendance;


    public AttendanceInformation(Person person, Attendance attendance) {
        this.person = person;
        this.attendance = attendance;
    }
    public AttendanceInformation() {
        this.person = new Person();
        this.attendance= new Attendance();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
