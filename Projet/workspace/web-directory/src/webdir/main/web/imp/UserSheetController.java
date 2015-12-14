package webdir.main.web.imp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdir.main.business.services.IPersonService;

@Controller
@RequestMapping("/usersheet{id}")
public class UserSheetController extends WebDirController {
	
	/** Service d'accès aux personnes */
	private IPersonService personServ;
	
	@PostConstruct
    public void init() {
    	super.init();
    	personServ.init();
    }
    
    @PreDestroy
    public void close() {
    	//personServ.close();
    }
    
    public IPersonService getPersonServ() {
    	return personServ;
    }
    
    @Autowired
    public void setPersonServ(IPersonService personServ) {
    	this.personServ = personServ;
    }

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView printPersonSheet(@MatrixVariable long id) {
    	ModelAndView sheet = getModelAndView("sheet");
    	
    	if(userInfo.isAuthenticated()) {
	    	try {
	    		sheet.addObject("person", personServ.getPerson(id));
			} catch (Exception e) {
				logger.error("Requested person not found (Person id : " + id + ". "
								+ "Controller : " + this);
				errorPage("Désolé, la personne demandée est introuvable.");
			}
	    	
	    	return sheet;
    	}
    	else
    		return warningPage("Vous devez être connecté à votre compte "
    				+ "utilisateur pour avoir accès à cette page.");
    }
	
	@RequestMapping(value="/edit{id}", method = RequestMethod.GET)
	public ModelAndView test() {
		return getModelAndView("redirect:/home");
	}
}
