package api_rest_jpa_sir.api_rest_jpa_sir.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/

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


