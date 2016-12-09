package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import play.db.Database;
import play.mvc.*;
import play.data.FormFactory;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import static  play.libs.Json.toJson;
import persistence.*;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonController extends Controller {
    private Database db;

    @javax.inject.Inject
    public PersonController(Database db){
        this.db = db;
    }



    public Result getStudent( int person_id){
        ArrayList<Person> students=new ArrayList<Person>();
        Person person=null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql = "select * " +
                    "from person where person_id=? AND person_type=0";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, person_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                students.add(new Person( rs.getInt("person_id"),
                        rs.getString("person_name"),
                        rs.getString("person_last_name"),
                        rs.getInt("person_type"),
                        rs.getString("person_uprm_id"),
                        rs.getString("person_rfid"),
                        rs.getString("person_email"),
                        rs.getString("person_password")));
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println("Failed SQL Extraction");
            e.printStackTrace();

        }
        finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        if (students.size()==0){
            students.add( new Person());
            System.out.println("Person does not Exist");
            return status(400, "Student does not Exist");
        }

        return ok(toJson(students));
    }

    public Result attendanceInformation( int section_id){
        ArrayList<AttendanceInformation> attendanceReport=new ArrayList<AttendanceInformation>();
        Person person=null;
        Attendance attendance= null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql = "select distinct attendance.*, person.* from attendance " +
                    " join enrollment on attendance_section_id=enrollment_section_id " +
                    " join person on person_id=attendance_student_id "+
                    " join sections on enrollment_section_id=section_id " +
                    " join course on sections.course_id=course.course_id "+
                    " where section_id=?  " +
                    "and attendance_date=current_date " +
                    "order by person_id";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, section_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                person = new Person( rs.getInt("person_id"),
                        rs.getString("person_name"),
                        rs.getString("person_last_name"),
                        rs.getInt("person_type"),
                        rs.getString("person_uprm_id"),
                        rs.getString("person_rfid"),
                        rs.getString("person_email"),
                        rs.getString("person_password"));
                attendance = new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getBoolean("attendance_status"),
                        rs.getString("attendance_date"),
                        rs.getInt("attendance_student_id"),
                        rs.getInt("attendance_section_session"),
                        rs.getString("attendance_comment"),
                        rs.getInt("attendance_section_id") );

                attendanceReport.add( new AttendanceInformation(person, attendance));
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println("Failed SQL Extraction");
            e.printStackTrace();

        }
        finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        if (attendanceReport.size()==0){
            attendanceReport.add( new AttendanceInformation());
            System.out.println("Section Attendance does not exist");
            return status(400, "Section Attendance does not exist");
        }

        return ok(toJson(attendanceReport));
    }

    public Result attendanceForStuedentInSection( int section_id, int student_id){
        ArrayList<AttendanceInformation> attendanceReport=new ArrayList<AttendanceInformation>();
        Person person=null;
        Attendance attendance= null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql = "select distinct attendance.*, person.* from attendance " +
                    " join enrollment on attendance_section_id=enrollment_section_id " +
                    " join person on person_id=attendance_student_id "+
                    " join sections on enrollment_section_id=section_id " +
                    " join course on sections.course_id=course.course_id "+
                    " where section_id=? and person_id=? order by person_id";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, section_id);
            statement.setInt(2, student_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                person = new Person( rs.getInt("person_id"),
                        rs.getString("person_name"),
                        rs.getString("person_last_name"),
                        rs.getInt("person_type"),
                        rs.getString("person_uprm_id"),
                        rs.getString("person_rfid"),
                        rs.getString("person_email"),
                        rs.getString("person_password"));
                attendance = new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getBoolean("attendance_status"),
                        rs.getString("attendance_date"),
                        rs.getInt("attendance_student_id"),
                        rs.getInt("attendance_section_session"),
                        rs.getString("attendance_comment"),
                        rs.getInt("attendance_section_id") );

                attendanceReport.add( new AttendanceInformation(person, attendance));
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println("Failed SQL Extraction");
            e.printStackTrace();

        }
        finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        if (attendanceReport.size()==0){
            attendanceReport.add( new AttendanceInformation());
            System.out.println("Section Attendance does not exist");
            return status(400, "Section Attendance does not exist");
        }

        return ok(toJson(attendanceReport));
    }

    public Result getProfessor( int person_id){
        ArrayList<Person> students=new ArrayList<Person>();
        Person person=null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql = "select * " +
                    "from person where person_id=? AND person_type=1";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, person_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                students.add(new Person( rs.getInt("person_id"),
                        rs.getString("person_name"),
                        rs.getString("person_last_name"),
                        rs.getInt("person_type"),
                        rs.getString("person_uprm_id"),
                        rs.getString("person_rfid"),
                        rs.getString("person_email"),
                        rs.getString("person_password")));
            }
            rs.close();
        }
        catch(Exception e){
            System.out.println("Failed SQL Extraction");
            e.printStackTrace();

        }
        finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        if (students.size()==0){
            students.add( new Person());
            System.out.println("Person does not Exist");
            return status(400, "Professor does not Exist");
        }

        return ok(toJson(students));
    }

    public Result getProfessorSections(int route_professor_id) {
        ArrayList<SectionInformation> sections=new ArrayList<>();
        Person person= null;
        Section section = null;
        Course course=null;
        JsonNode json = request().body().asJson();

        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql ="select person.*, sections.*, course.* " +
                    "FROM sections " +
                    "JOIN person ON sections.professor_id = person.person_id " +
                    "JOIN course ON sections.course_id = course.course_id " +
                    "WHERE professor_id= ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, route_professor_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                person= new Person(rs.getInt("person_id"),
                        rs.getString("person_name"),
                        rs.getString("person_last_name"),
                        rs.getInt("person_type"),
                        rs.getString("person_uprm_id"),
                        rs.getString("person_rfid"),
                        rs.getString("person_email"),
                        rs.getString("person_password")
                );
                section= new Section(
                        rs.getInt("section_id"),
                        rs.getString("section_name"),
                        rs.getInt("course_id"),
                        rs.getString("section_term"),
                        rs.getString("professor_id"));

                course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_name")
                );
                sections.add( new SectionInformation( person, section,course));
            }

            rs.close();
        }
        catch(Exception e){
            System.out.println("Failed SQL Extraction");
            e.printStackTrace();

        }
        finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return ok(toJson(sections));
    }

}
