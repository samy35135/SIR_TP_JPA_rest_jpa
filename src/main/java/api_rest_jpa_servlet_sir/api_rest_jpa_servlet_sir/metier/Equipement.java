package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Equipement")
public class Equipement extends PeripheriquesIntelligents {

	private int superficiechaufage;
	
	public Equipement(){
		super();
	}

	public int getSuperficiechauffage() {
		return superficiechaufage;
	}


	public void setSuperficiechauffage(int superficiechaufage) {
		this.superficiechaufage = superficiechaufage;
	}
	
}


