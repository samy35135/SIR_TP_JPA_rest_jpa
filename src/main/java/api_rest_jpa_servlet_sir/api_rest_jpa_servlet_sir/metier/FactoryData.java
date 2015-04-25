package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

public class FactoryData {
	private EntityManager manager;
	private Equipement equipement;
	private Chauffage chauffage;
	private Person personne;
	private Person personne2;
	private Person personne3;
	private Home maison;
	private Home maison2;
	
	
	public FactoryData(EntityManager manager){
		this.manager = manager;
	}
	
	/** 
	 * Permet de créer des équipements
	 */
	public void createEquipement(){
		/*int nbEquip = manager.createQuery("SELECT a FROM Equipement a", Equipement.class).getResultList().size();
		
		if(nbEquip == 0){*/
			equipement = new Equipement();
			equipement.setName("electrique");
			equipement.setConsommation(95);
			equipement.setSuperficiechauffage(50);
		//}
	}
	public void createChauffage(){
		/*int nbEquip = manager.createQuery("SELECT a FROM Chauffage a", Chauffage.class).getResultList().size();
		
		if(nbEquip == 0){*/
			chauffage = new Chauffage();
			chauffage.setName("chauffage");
			chauffage.setConsommation(115);
			chauffage.setCapacite(66);
			
		//}
	}
	
	/**
	 * Permet d'instancier personne, personne2 et personne3
	 */
	public void createPersonne(){
		/*int nbPers = manager.createQuery("SELECT p FROM Person p", Person.class).getResultList().size();
		
		if(nbPers == 0 ){*/
			personne = new Person();
			personne.setNom("Fabrice");
			personne.setPrenom("laporte");
			personne.setSexe("M");
			personne.setLoginFB("FB");
			personne.setDate_naissance(new Date("10/12/1988"));
			personne.setAdressmail("fablp@laorte.com");
		
			personne2 = new Person();
			personne2.setNom("Marc");
			personne2.setPrenom("hippolyte");
			personne2.setSexe("M");
			personne2.setLoginFB("Mhipo");
			personne2.setDate_naissance(new Date("10/12/1988"));
			personne2.setAdressmail("mhypop@laorte.com");
			
			personne3 = new Person();
			personne3.setNom("Coste");
			personne3.setPrenom("Marjorie");
			personne3.setSexe("F");
			personne3.setLoginFB("Mo");
			personne3.setDate_naissance(new Date("10/12/1988"));
			personne3.setAdressmail("marjorie@coste.com");
			
		//}
	}
	
	/**
	 * Permet de créer une maison s'il n'y en a aucune en base
	 */
	public void createMaison(){
		/*int nbHome = manager.createQuery("SELECT p FROM Home p", Home.class).getResultList().size();
		if(nbHome == 0 ){*/
			maison = new Home();
			maison.setAdressIP("00");
			maison.setAdress("adresse0");
			maison.setSuperficie(10);
			
			
			maison2 = new Home();
			maison2.setAdressIP("01");
			maison2.setAdress("adress1");
			maison.setSuperficie(5);
		//}
	}

	/**
	 * Ajoute de equipement et chauffage à la maison
	 */
	public void liaisonHomeEquipement(){	
		ArrayList<PeripheriquesIntelligents> listPeriphInt=new ArrayList<PeripheriquesIntelligents>();
		listPeriphInt.add(equipement);
		listPeriphInt.add(chauffage);
		maison.setListEquipement(listPeriphInt);
	}
	
	/**
	 * Ajoute maison et maison à personne
	 */
	public void liaisonPersonHome(){
		ArrayList<Home> listHome=new ArrayList<Home>();
		listHome.add(maison);
		listHome.add(maison2);
		personne.setListMaison(listHome);
	}
	
	
	/**
	 * Ajoute des amis à personne
	 */
	public void liaisonFriends(){
		ArrayList<Person> listFriends=new ArrayList<Person>();
		listFriends.add(personne2);
		listFriends.add(personne3);
		personne.setFriends(listFriends);
	}

	public void dataGenerator(){
		//crÈation entitÈs
		this.createEquipement();
		this.createChauffage();
		this.createMaison();
		this.createPersonne();
		
		this.liaisonHomeEquipement();
		this.liaisonFriends();
		this.liaisonPersonHome();
		
		this.sauvegarderPersist();
		
	}
	public void sauvegarderPersist() {
		manager.persist(personne);
	}
	//public void ajouterEquipement
}
