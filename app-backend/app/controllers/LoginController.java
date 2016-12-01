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

public class LoginController extends Controller {

    private String email;
    private String password;


    @Inject
    public LoginController(Counter counter) {
        this.email="";
        this.password="";
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result login() {
        //return ok("Get returning Count"+ "NumberKeyTest:" +toJson(counter.nextCount()));
        //response().setHeader(ETAG, "Testing Response");
        JsonNode json = request().body().asJson();
        this.email=json.findValue("name").toString();
        this.password=json.findValue("password").toString();
        return ok("Got JSON Object: Proof " + json);


    }




}
