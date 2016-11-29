package controllers;
import play.mvc.*;
import play.data.FormFactory;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import static  play.libs.Json.toJson;
import persistence.*;
import models.*;

public class PersonController extends Controller {

    DAOStudent daoStudent= new DAOStudent();
    public Result getStudent( int person_id){
    return ok(toJson( daoStudent.getObjectById(person_id)));
    }

    public Result getStudents(){
        return ok(toJson( daoStudent.getAllObjetcs()));
    }
}
