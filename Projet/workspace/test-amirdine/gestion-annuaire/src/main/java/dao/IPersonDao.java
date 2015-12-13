package dao;

import java.util.List;

import model.Person;

public interface IPersonDao {

	public void addPerson(Person person);
	public Person getPerson(long id) throws Exception;
	public List<Person> getAllPersons();
	
   /**
    * Permet de vérifier si l'id d'une personne existe dans la base de donnees.
	* @param id identifiant de la personne.
	* @return True ou False.
	*/
    public boolean personIDExists(long id);
}
