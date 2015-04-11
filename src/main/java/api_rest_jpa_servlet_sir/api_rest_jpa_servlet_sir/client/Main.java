package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier.FactoryData;

public class Main {

	public static void main(String[] args) {
		// Génération de l'entity manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Abh_Col_SIR_TP_JPA_REST_SERVLET");
		EntityManager manager = factory.createEntityManager();
		FactoryData usine = new FactoryData(manager);
		//View vue = new View(manager);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		usine.dataGenerator();

		tx.commit();

		System.out.println(".. done");

	}

}
