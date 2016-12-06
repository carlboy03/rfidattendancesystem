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
