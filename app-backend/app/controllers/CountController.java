package controllers;
import static play.libs.Json.toJson;
import javax.inject.*;

import com.fasterxml.jackson.databind.JsonNode;
import play.*;
import play.mvc.*;

import play.data.FormFactory;
import services.Counter;
import models.*;
import models.Person;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton

public class CountController extends Controller {

    private final Counter counter;
    private String name;
    private String rfidValue;


    @Inject
    public CountController(Counter counter) {
       this.counter = counter;
        this.name="";
        this.rfidValue="";
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result count() {
        //return ok("Get returning Count"+ "NumberKeyTest:" +toJson(counter.nextCount()));
        response().setContentType("application/json");
        response().setHeader(ETAG, "Testing Response");
        JsonNode json = request().body().asJson();
       this.name=json.findValue("name").toString();
        this.rfidValue=json.findValue("RFID Value").toString();
        return ok("Got JSON Object: Proof " + json);
    }

    public Result countPost() {


        return ok(

                "name: "+ "Carlos0\n\r" + "name2: "+ "Carlos2\n\r" + "name4: "+ "Carlo4s\n\r" + "nam4e: "+ "Catrlos\n\r");
    }

    public Result countGet() {
        //return ok("Get returning Count"+ "NumberKeyTest:" +toJson(counter.nextCount()));
        response().setContentType("application/json");
        response().setHeader(ETAG, "Testing Response");
        JsonNode json = request().body().asJson();

        return ok("Current Name" + this.name +"\n\r"+ "Current RFID: "+ this.rfidValue);

    }


}
