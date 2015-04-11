package api_rest_jpa_sir.api_rest_jpa_sir.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import api_rest_jpa_sir.api_rest_jpa_sir.metier.FactoryData;
import api_rest_jpa_sir.api_rest_jpa_sir.metier.Person;

public class Main {

	private EntityManager manager;

	public Main(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {
		// Génération de l'entity manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Abh_Col_SIR_TP_JPA");
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
