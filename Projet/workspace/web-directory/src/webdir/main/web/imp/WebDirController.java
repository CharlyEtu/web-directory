package webdir.main.web.imp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import webdir.main.business.services.IGroupService;
import webdir.main.model.UserInfo;

public class WebDirController {
	/** Logger d'apache */
    protected Log logger = LogFactory.getLog(getClass());
    
    /** Service d'accès aux groupes */
	protected IGroupService groupServ;
	
	/** Informations sur l'utilisateur courant. */
	@Autowired
	protected UserInfo userInfo;
    
    @PostConstruct
    public void init() {
    	groupServ.init();
    }
    
    @PreDestroy
    public void close() {
    	//groupServ.close();
    }
    
    @ModelAttribute("userInfo")
    public UserInfo getUserInfo() {
    	return userInfo;
    }
    
    @Autowired
    public void setGroupServ(IGroupService groupServ) {
    	this.groupServ = groupServ;
    }
    
    public IGroupService getGroupServ() {
    	return groupServ;
    }
    
    /**
     * Obtenir un objet de type ModelAndView, accompagné des ressources de base
     * nécessaires à un affichage correct de la vue.
     * @param viewName Le nom de la vue souhaitée.
     * @return L'objet ModelAndView souhaité.
     */
    public ModelAndView getModelAndView(String viewName) {
    	ModelAndView mav = new ModelAndView(viewName);
    	
    	mav.addObject("groupIterator", groupServ.getAllGroups().iterator());
    	
    	return mav;
    }
    
    public ModelAndView errorPage(String errMsg) {
    	ModelAndView error = getModelAndView("error");
    	
    	error.addObject("errMsg", errMsg);
    	
    	return error;
    }
    
    public ModelAndView warningPage(String warnMsg) {
    	ModelAndView warning = getModelAndView("warning");
    	
    	warning.addObject("warnMsg", warnMsg);
    	
    	return warning;
    }
}
