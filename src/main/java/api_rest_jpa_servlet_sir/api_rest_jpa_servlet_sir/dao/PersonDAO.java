package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier.Person;



public class PersonDAO {
	
	private static String queryById = "SELECT p from Person p "
			+ " WHERE id = :personid ";
	private static String queryPerson = "SELECT p from Person p";
	/**
	 * Récupère un utilisateur dans la base grace à son id
	 * @param manager
	 * @param userid
	 * @return
	 */
	public static Person getPersonId(EntityManager manager, int personid) {
		try {
			Person person = manager.createQuery(queryById, Person.class)
					.setParameter("personid", personid).getSingleResult();
			return person;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public static List<Person> getPersons(EntityManager manager) {
		try {
			List<Person> personnes = manager.createQuery(queryPerson, Person.class).getResultList();
			return personnes;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}


