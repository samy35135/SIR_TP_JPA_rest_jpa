package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.rest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.dao.PersonDAO;
import api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier.Person;


@Path("/personne")
public class Rest_Person {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, sublime projet par Abh et Coll";
    }

	
	@GET
	@Path("/id/{personneid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getUserById(@PathParam("personneid") int personid) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Abh_Col_SIR_TP_JPA");
		EntityManager manager = factory.createEntityManager();
		return PersonDAO.getPersonId(manager, personid);
	}
	

}

