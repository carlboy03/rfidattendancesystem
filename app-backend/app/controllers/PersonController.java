package controllers;
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
                    "from person where person_type=1";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                students.add(new Person( rs.getInt("person_id"),
                        rs.getString("person_name"),
                        rs.getString("person_last_name"),
                        rs.getInt("person_type"),
                        rs.getString("person_uprm_id"),
                        rs.getString("person_rfid")));
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
        }

        return ok(toJson(students));
    }

//    public Result getStudents(){
//        return ok(toJson( daoStudent.getAllObjetcs()));
//    }
}
