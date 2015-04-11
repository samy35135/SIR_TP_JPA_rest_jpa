package api_rest_jpa_sir.api_rest_jpa_sir.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Home {
	
	private int id;
	
	private  String adressIP;
	
	private String adress;
	
	private int superficie;
	
	private List<PeripheriquesIntelligents> listEquipement = new ArrayList<PeripheriquesIntelligents>();
	
	public Home(){}
	
	
	
	public String getAdressIP() {
		return adressIP;
	}

	public void setAdressIP(String aressIP) {
		this.adressIP = aressIP;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	@OneToMany(cascade=CascadeType.PERSIST)
	public List<PeripheriquesIntelligents> getListEquipement() {
		return listEquipement;
	}

	public void setListEquipement(List<PeripheriquesIntelligents> listEquipement) {
		this.listEquipement = listEquipement;
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
}
