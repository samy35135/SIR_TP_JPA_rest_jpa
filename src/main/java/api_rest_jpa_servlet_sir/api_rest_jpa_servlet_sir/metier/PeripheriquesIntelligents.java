package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier;
s

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class PeripheriquesIntelligents {
	private String name;
	private int consommation;
	private int IdEQ;
	
	public 	PeripheriquesIntelligents(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getConsommation() {
		return consommation;
	}

	public void setConsommation(int consommation) {
		this.consommation = consommation;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
		@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdEQ() {
		return IdEQ;
	}

	public void setIdEQ(int idEQ) {
		IdEQ = idEQ;
	}
	

}
