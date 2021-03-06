package webdir.main.web.imp;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdir.main.business.services.IGroupService;
import webdir.main.business.services.IPersonService;
import webdir.main.model.Group;
import webdir.main.model.Person;
import webdir.main.web.IHomeController;

@Controller()
@RequestMapping("*")
public class HomeController implements IHomeController {

	/** Service d'accès aux personnes */
	private IPersonService personServ;
	
	/** Service d'accès aux groupes */
	private IGroupService groupServ; 
	
	/** Logger d'apache */
    private final Log logger = LogFactory.getLog(getClass());
    
    @PostConstruct
    public void init() {
    	personServ.init();
    	groupServ.init();
    }
    
    @PreDestroy
    public void close() {
    	//personServ.close();
    }
    
    @Autowired
    public void setPersonServ(IPersonService personServ) {
    	this.personServ = personServ;
    }
    
    public IPersonService getPersonServ() {
    	return personServ;
    }
    
    @Autowired
    public void setGroupServ(IGroupService groupServ) {
    	this.groupServ = groupServ;
    }
    
    public IGroupService getGroupServ() {
    	return groupServ;
    }
    
    public ModelAndView addBasicPageResources(ModelAndView mav) {
    	mav.addObject("groupIterator", groupServ.getAllGroups().iterator());
    	
    	return mav;
    }
    
    public ModelAndView errorPage(String errMsg) {
    	ModelAndView mav = new ModelAndView("error");
    	
    	mav = addBasicPageResources(mav);
    	mav.addObject("errMsg", errMsg);
    	
    	return mav;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView printHome() {
    	Collection<Person> pList;
    	ModelAndView mav = new ModelAndView("home");
    	
    	logger.info("Home page printing with " + this);
    	
    	/* Ajout des ressources de base de la page */
    	mav = addBasicPageResources(mav);
        
    	/* Acquisition et ajout de la liste des personnes */
        pList = personServ.getAllPersons();
        // Vérification de la bonne réception
        if(pList == null)
        	return errorPage("L'acquisition de la liste des personnes de l'annuaire à échouée.");
        mav.addObject("personIterator", pList.iterator());
        
        /* Acquisition et ajout de la liste des groupes */
        Collection<Group> gList = groupServ.getAllGroups();
        // Vérification de la bonne réception
        if(gList == null)
        	return errorPage("L'acquisition de la liste des groupes de l'annuaire à échouée.");
        mav.addObject("groupIterator", gList.iterator());
        
        return mav;
    }
}