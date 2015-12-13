package service;

public interface IUserService {
	
   /**
	* Permet l'authentification d'une personne.
	* @param login - Identifiant de la personne.
	* @param password - Mot de passe.
	* @return  True si le login et le mot de passe sont correct.
    * @throws Exception 
	*/
    public boolean connect(long login, String password) throws Exception;

    
   /**
   	*  Retourne le prénom de la personne personne connectee.
   	* @return un objet Person
   	*/
   	public String getUserFisrtsname();

}
