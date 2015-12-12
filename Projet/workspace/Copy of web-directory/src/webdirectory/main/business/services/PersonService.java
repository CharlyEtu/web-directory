package webdirectory.main.business.services;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import webdirectory.main.business.dao.PersonDao;
import webdirectory.main.model.Person;

/**
 * Service d'acces aux donnes metiers de type Person.
 */
@Service
public class PersonService implements IPersonService {

	PersonDao personDao = new PersonDao();
	
	/**
	 * Initialise la connexion a la base de donnes.
	 */
	@PostConstruct
	public void init() {
		personDao.init();
	}
      
   /**
	* Retourne la liste de toutes les personnes de l'annuaire.
	* @return Liste de toutes les personnes present dans l'annuaire.
	*/
	public Collection<Person> getAllPersons() {
		
		personDao.init();
		List<Person> persons = personDao.getAllPersons();
		return persons;
	}
	
   /**
	* @param id Identifiant de la personne
	* @return l'objet Personne.
	*/
	public Person getPerson(long id) throws Exception{	
		personDao.init();
		return personDao.getPerson(id);
	}

   /**
	* Permet de vérifier si un identifiant existe.
	* @param id Identifiant d'une personne.
	* @return true si l'id existe, return flase si l'id n'existe pas.
	*/
	public boolean personIDExists(long id){
		personDao.init();
		return personDao.personIdExists(id);
	}
}