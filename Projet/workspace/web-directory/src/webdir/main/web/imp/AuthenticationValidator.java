package webdir.main.web.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import webdir.main.business.services.IPersonService;
import webdir.main.model.AuthenticationForm;
import webdir.main.model.Person;

@Service
public class AuthenticationValidator implements Validator {
	
	/** Service d'accès aux personnes */
	private IPersonService personServ;
	
	/**
	 * Initialiser du service.
	 */
	public void init() {
		personServ.init();
	}
	
	/**
	 * Fermer le service.
	 */
	public void close() {
		//personServ.close();
	}
	
	/**
	 * Obtenir le service d'accès aux personnes de ce validateur.
	 * @return Le service d'accès aux personnes.
	 */
	public IPersonService getPersonServ() {
		return personServ;
	}
	
	/**
	 * Affecter le service d'accès aux personnes.
	 * @param personServ Le service à affecter.
	 */
	@Autowired
	public void setPersonServ(IPersonService personServ) {
		this.personServ = personServ;
	}
	
	/**
	 * Obtenir le mot de passe d'un personne.
	 * @param login Le login (email) de la personne en question.
	 * @return Le mot de passe de la personne, null si aucune personne ne correspond
	 * 		   au login donné en paramètre.
	 * @throws Exception 
	 */
	private String getPersonPwd(String login) throws Exception {
		Person p = personServ.getPerson(login);
		
		if(p == null)
			return null;
		else
			return p.getPassword();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return AuthenticationForm.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		String login, formPwd, personPwd = null;
		AuthenticationForm form = (AuthenticationForm) target;
		
		/* Validation de l'entrée login */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", 
				"authentication.login", "L'email est requis !");
		
		/* Validation de l'entrée pwd */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", 
				"authentication.pwd", "Le mot de passe est requis !");
		
		/* Authentification */
		login = form.getLogin();
		formPwd = form.getPwd();
		
		try {
			personPwd = getPersonPwd(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((personPwd == null)|| (formPwd.compareTo(personPwd) != 0)) {
			errors.rejectValue("login", "authentication.login",
					"Il est possible que le login donné soit erroné !");
			errors.rejectValue("pwd", "authentication.pwd",
					"Il est possible que le mot de passe donné soit erroné !");
		}
	}
}
