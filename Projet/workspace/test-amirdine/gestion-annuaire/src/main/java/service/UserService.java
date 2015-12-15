package service;

import dao.PersonDao;
import model.Person;


/**
 * Classe pour l'authentificaion.
 *
 */
public class UserService implements IUserService {
	
    
	PersonDao personDao = new PersonDao();
    
    private Person person;
	
   /**
    * Permet l'authentification d'une personne.
    * @param login - Identifiant de la personne.
    * @param password - Mot de passe.
    * @return  True si le login et le mot de passe sont correct.
    */
	public boolean connect(long login, String password) throws Exception{
		
		personDao.init();
		if(personDao.personIDExists(login)){
			
			person = personDao.getPerson(login);
			
			if(person.getPassword().contentEquals(password)){
				System.out.println("True");
				return true;
			}	
		}
		
		return false;
	}

	
   /**
	*  Retourne le prénom de la personne personne connectee.
	* @return  prénom de la la personne connectee.
	*/
	public String getUserFisrtsname(){
		return person.getFirstname();
	}
	
   /**
	*  Retourne le noom de famille de la personne personne connectee.
	* @return un objet Person
	*/
	public String getUserLastsname(){
		return person.getLastname();
	}
	

}
