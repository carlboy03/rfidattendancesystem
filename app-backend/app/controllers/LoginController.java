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

public class LoginController extends Controller {

    private String email;
    private String password;
    private Database db;

    @javax.inject.Inject
    public LoginController(Database db){
        this.db = db;
        this.email="";
        this.password="";
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
    public Result login() {

        JsonNode json = request().body().asJson();
        this.email=json.findValue("email").textValue();
        this.password=json.findValue("password").textValue();
        Person person=null;
        Connection connection = db.getConnection();

        PreparedStatement statement = null;

        try{
            String sql = "select * " +
                    "from person where person_type=1 " +
                    "AND person_email= ? " +
                    "AND person_password= ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
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
            System.out.println("Person does not Exist");
        }

        return ok(toJson(person));


    }




}
