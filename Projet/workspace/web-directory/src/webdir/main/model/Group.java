package webdir.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe representant l'objet groupe.
 */

@Entity(name = "Group_")
public class Group {


	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private long group_id;
	
	@Column(name = "groupe", length = 200, nullable = false)
	private String name;
	
   /**
    * Retourne l'identifiant du groupe
	* @return L'identifiant du groupe.
	*/
	public long getID() {
		return group_id;
	}
	
   /**
    * Permet de fixer l'identifiant du groupe.
	* @param id numerdo du groupe.
	*/
	public void setId(long id) {
		this.group_id = id;
	}
	
   /**
    * Retourne le nom du groupe.
    * @return Le nom du groupe.
    */
	public String getName() {
		return name;
	}
	
   /**
    * Permet de fixer le nom du groupe.
	* @param name Nom.
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		
		String string = "Groupe: \n";
		
		string += "- Prénom: " + getID() + "\n";
		string += "- Nom: " + getName() + "\n";
		
		return string;
	}
	
		
}