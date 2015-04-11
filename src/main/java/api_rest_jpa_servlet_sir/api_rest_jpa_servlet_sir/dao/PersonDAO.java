package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier.Person;



public class PersonDAO {
	
	private static String queryById = "SELECT p from Person p "
			+ " WHERE id = :personid ";
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
}
