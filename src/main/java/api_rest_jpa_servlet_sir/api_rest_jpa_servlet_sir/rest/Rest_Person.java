package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.rest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Path("personnes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons(){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Abh_Col_SIR_TP_JPA_REST_SERVLET");
		EntityManager manager = factory.createEntityManager();
		return PersonDAO.getPersons(manager);
	}
	
	@GET
	@Path("/id/{personneid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPeronById(@PathParam("personneid") int personid) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Abh_Col_SIR_TP_JPA_REST_SERVLET");
		EntityManager manager = factory.createEntityManager();
		return PersonDAO.getPersonId(manager, personid);
	}
	
	@POST
	@Path("/insererpersonne")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertPerson(Person person){
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Abh_Col_SIR_TP_JPA_REST_SERVLET");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(person);
		
		tx.commit();
		
		return Response.status(200).entity(true).build();
	}

}

