package api_rest_jpa_sir.api_rest_jpa_sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api_rest_jpa_sir.api_rest_jpa_sir.client.Main;
@Path("/generatedata")
public class GenerateData {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, sublime projet par Abh et Coll";
    }

	@GET
	@Path("/main")
	@Produces(MediaType.TEXT_PLAIN)
	public String launchMain(){
		Main.main(null);
		return "Done";
	}
}
