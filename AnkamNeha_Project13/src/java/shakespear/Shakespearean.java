/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespear;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Neha Ankam
 */
@Path("shake")
public class Shakespearean {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Shakespearean
     */
    public Shakespearean() {
    }

    /**
     * Retrieves representation of an instance of shakespear.Shakespearean
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
       List<String> adjec1 = new ArrayList<String>();
        adjec1.add("bootless");
        adjec1.add("clouted");
        adjec1.add("droning");
        adjec1.add("impertinent");
        adjec1.add("mammering");
        List<String> adjec2 = new ArrayList<String>();
        adjec2.add("common-kissing");
        adjec2.add("fool-born");
        adjec2.add("hedge-born");
        adjec2.add("knotty-pated");
        adjec2.add("rough-hewn");
        List<String> noun = new ArrayList<String>();
        noun.add("apple-john");
        noun.add("clotpole");
        noun.add("hugger-mugger");
        noun.add("moldwarp");
        noun.add("pigeon-egg");
        Random ran = new Random();
        
        JsonObject fResult = Json.createObjectBuilder().add("first",adjec1.get(ran.nextInt(adjec1.size())))
                .add("last",adjec2.get(ran.nextInt(adjec2.size())))
                .add("noun",noun.get(ran.nextInt(noun.size()))).build();
        StringWriter strWriter = new StringWriter();
        JsonWriter jsonwriter = Json.createWriter(strWriter);
        jsonwriter.writeObject(fResult);
        jsonwriter.close();
        return strWriter.toString();

    }

    /**
     * PUT method for updating or creating an instance of Shakespearean
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
