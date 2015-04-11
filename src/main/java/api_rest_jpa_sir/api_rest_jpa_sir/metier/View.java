package api_rest_jpa_sir.api_rest_jpa_sir.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


public class View {
	private EntityManager manager;
	Equipement Equipement;
	
	public View(EntityManager manager){
		this.manager=manager;
	}
	
	public void affichageEquipements(){
		List<Equipement> listEquipement = manager.createQuery("SELECT a FROM Equipement a",Equipement.class).getResultList();

		System.out.println("nombre d' équipements : "+listEquipement.size());
		for(Equipement next : listEquipement){
			System.out.println("Equipement : "+ next.getName());
		}
		
	}
	public void affichagePersonnes(){
		List<Person> listPersonnes = manager.createQuery("SELECT a FROM Person a",Person.class).getResultList();
		
		
		System.out.println("nombre de Personnes : "+listPersonnes.size());
		for(Person next : listPersonnes){
			System.out.println("Personne : "+ next.getNom());
		}
		
	}
	public void affichageMaisons(){
		List<Home> listMaison = manager.createQuery("SELECT a FROM Home a",Home.class).getResultList();

		System.out.println("nombre de Maisons : "+listMaison.size());
		for(Home next : listMaison){
			System.out.println("Maison : "+ next.getAdress());
		}
		
	}

}
