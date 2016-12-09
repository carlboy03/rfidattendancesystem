package controllers;
import static play.libs.Json.toJson;
import javax.inject.*;

import com.fasterxml.jackson.databind.JsonNode;
import play.*;
import play.db.Database;
import play.mvc.*;

import play.data.FormFactory;
import services.Counter;
import models.*;
import models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton

public class RFIDController extends Controller {

    private String rfid;
    private Database db;

    @javax.inject.Inject
    public RFIDController(Database db){
        this.db = db;
        this.rfid="";
    }
//    @Inject
//    public LoginController(Counter counter) {
//        this.email="";
//        this.password="";
//    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result RfidScanned() {

        JsonNode json = request().body().asJson();
        this.rfid=json.findValue("rfid").textValue();

        System.out.println("Received POST");
        Person person=null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql ="select * from person where person_rfid=? AND person_type=0";
            statement = connection.prepareStatement(sql);
            statement.setString(1, rfid);
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
        if (person==null){
            person=( new Person());
            System.out.println("RFID Record does not Exist");
            return status(401, "RFID record does not Exist");
        }
        this.rfid=null;
        System.out.println("RFID Record Exist");
        return ok("RFID record does Exist");


    }

    public Result RfidScannedSection1() {

        JsonNode json = request().body().asJson();
        this.rfid=json.findValue("rfid").textValue();
        int currentSection=7;
        System.out.println("Received POST");
        Person person=null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql ="SELECT DISTINCT person.* from enrollment "+
                    "join person on person_id=enrollment_student_id "+
                    "where enrollment_section_id=? and person_rfid= ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, currentSection);
            statement.setString(2, rfid);
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
        if (person==null){
            System.out.println("RFID Record does not Exist");
            return status(401, "RFID record does not Exist");
        }
        try{
            String sql ="INSERT INTO attendance (attendance_status, attendance_date, attendance_student_id, " +
                    "attendance_section_session, attendance_comment, attendance_section_id) " +
                    "VALUES (TRUE, current_date, ?, 2,'No comment' ,?  );";
            connection = db.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, person.getPerson_id());
            statement.setInt(2,currentSection );
            statement.executeUpdate();
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
        this.rfid=null;
        return ok("RFID record does Exist");


    }





}
