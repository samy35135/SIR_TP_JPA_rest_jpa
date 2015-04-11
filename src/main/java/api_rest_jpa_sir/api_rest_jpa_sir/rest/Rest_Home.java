package api_rest_jpa_sir.api_rest_jpa_sir.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api_rest_jpa_sir.api_rest_jpa_sir.metier.Chauffage;
import api_rest_jpa_sir.api_rest_jpa_sir.metier.Equipement;
import api_rest_jpa_sir.api_rest_jpa_sir.metier.Home;
import api_rest_jpa_sir.api_rest_jpa_sir.metier.PeripheriquesIntelligents;
@Path("/home")
public class Rest_Home {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, sublime projet par Abh et Coll";
    }

	@GET
    @Path("/example")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home();
        h.setAdressIP("127.0.0.1");
        h.setAdress("La ferme à Jerôme");
      
        Equipement equi1 = new Equipement();
        equi1.setSuperficiechauffage(185);
        
        Chauffage equi2 = new Chauffage();
        equi2.setCapacite(20);
        
        ArrayList<PeripheriquesIntelligents> listPeriphInt=new ArrayList<PeripheriquesIntelligents>();
        listPeriphInt.add(equi1);
        listPeriphInt.add(equi2);
        
        h.setListEquipement(listPeriphInt);

        return h;
    }

}
