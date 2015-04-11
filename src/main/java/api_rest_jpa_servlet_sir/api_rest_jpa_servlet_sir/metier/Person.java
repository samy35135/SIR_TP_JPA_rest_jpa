package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {
	private int id;
	private String prenom;
	private String nom;
	private String adressmail;
	private char sexe; //'F'
	private Date date_naissance;
	private String loginFB;
	private List<Home> listMaison = new ArrayList<Home>();
	private List<Person> friends = new ArrayList<Person>();
	
	public Person(){}
	
	/**
	 * Constructeur utilisé dans le cadre de la webapp
	 */
	public Person(String prenom, String nom, String adressmail, char sexe,
			Date date_naissance, String loginFB) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.adressmail = adressmail;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.loginFB = loginFB;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdressmail() {
		return adressmail;
	}
	public void setAdressmail(String adressmail) {
		this.adressmail = adressmail;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getLoginFB() {
		return loginFB;
	}
	public void setLoginFB(String loginFB) {
		this.loginFB = loginFB;
	}
	
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Home> getListMaison() {
		return listMaison;
		
	}

	public void setListMaison(List<Home> listMaison) {
		this.listMaison = listMaison;
	}
	@OneToMany(cascade=CascadeType.PERSIST)
	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
}
