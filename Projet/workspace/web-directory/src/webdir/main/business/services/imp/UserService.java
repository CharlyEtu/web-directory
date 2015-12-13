package webdir.main.business.services.imp;

import webdir.main.business.dao.IPersonDao;
import webdir.main.business.dao.imp.PersonDao;
import webdir.main.business.services.IEmailService;
import webdir.main.business.services.IUserService;
import webdir.main.model.Person;

/**
 * Classe pour l'authentificaion.
 *
 */
public class UserService implements IUserService {
	
    
	IPersonDao personDao = new PersonDao();
    
    private Person person;
	
   /**
    * Permet l'authentification d'une personne.
    * @param login - Identifiant de la personne.
    * @param password - Mot de passe.
    * @return  True si le login et le mot de passe sont correct.
    */
	public boolean connect(long login, String password) throws Exception{
		
		personDao.init();
		if(((PersonDao) personDao).personIDExists(login)){
			
			person = personDao.getPerson(login);
			
			if(person.getPassword().contentEquals(password)){
				return true;
			}	
		}
		return false;
	}
	
	
   /**
	* Permet à l'utilisateur de récupérer son mot de passe par e-mail.
	* @param id Indenfiant de l'utilisateur
	* @throws Exception
	*/
	public void sendUserPassword(long id) throws Exception{
		
		Person person = personDao.getPerson(id);
		String password = person.getPassword();
		
		IEmailService emailService = new EmailService();
		
		String recipient = person.getEmail();
		String subject = "récupération de votre mot de passe";
		String content = "Votre mot de passe est: " + password + "\n";
		
		emailService.sendEmail(recipient, subject, content);
	}

}
