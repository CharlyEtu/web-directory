/**
 * FIXME Ne faire qu'une seule initialisation de PersonDao ?
 * 		 (Plutôt que de réinitialiser à chaque appel de méthodes)
 */

package webdir.main.business.services.imp;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import webdir.main.business.dao.imp.GroupDao;
import webdir.main.business.services.IGroupService;
import webdir.main.model.Group;
import webdir.main.model.Person;



/**
 * Service d'acces aux donnes metiers de type Group.
 */
public class GroupService implements IGroupService{
	
	GroupDao groupDao = new GroupDao();
	
	
   /**
	* Initialise la connexion a la base de donnes.
    */
	@PostConstruct
	public void init() {
		groupDao.init();
	}

	/**
     * Retourne la liste de toutes les groupes.
     * @return Liste de toutes les groupes present dans l'annuaire.
     */
     public Collection<Group> getAllGroups() {
    	    groupDao.init();
			List<Group> groups = groupDao.getAllGroups();
			return groups;
	  }
     
   /**
 	* @param id Identifiant du groupe.
 	* @return l'objet Group.
 	*/
 	public Group getGroup(long id){	
 		groupDao.init();
 		return groupDao.getGroup(id);
 	}
 	
   /**
 	* Retourne les personnes contenu dans une groupe.
 	* @return Les personnes appartenant au groupe.
 	*/
 	public Collection<Person> getGroupContent(long id){
 		groupDao.init();
 		return groupDao.getContentGroup(id);
 	}
	
 	   /**
 		* Permet de vérifier si un identifiant existe.
 		* @param id Identifiant d'un groupe.
 		* @return true si l'id existe, return flase si l'id n'existe pas.
 		*/
 		public boolean groupIDExists(long id){
 			groupDao.init();
 			return groupDao.groupIdExists(id);
 		}
	
}
