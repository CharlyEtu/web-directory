package webdir.main.web.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import webdir.main.business.services.IGroupService;
import webdir.main.business.services.IPersonService;
import webdir.main.business.services.IUserService;
import webdir.main.business.services.imp.UserService;
import webdir.main.model.Group;
import webdir.main.model.Person;
import webdir.main.model.User;
import webdir.main.web.imp.validator.PersonValidator;
import webdir.main.web.imp.validator.UserValidator;


@RequestMapping("*")
@Controller()
public class PrototypeController {
	
	/*********************  USER ****************************/
	
	@Autowired()
    User user;

    @ModelAttribute("user")
    public User newUser() {
        return user;
    }
    
    /*******************  Validateur *************************/
    
    @Autowired
    UserValidator userValidator;
    
    
    /******************  Service utilisateur *****************/
    
    @Autowired
    IUserService userService;
    
   
    
    
    /********************************************************
     *   				AUTHENTIFICATION                    *
     *                                                      *
     ********************************************************/
    
    
     /***   GET  ***/
    
     protected final Log logger = LogFactory.getLog(getClass());
    
     @RequestMapping(value ="/login", method = RequestMethod.GET)
     public ModelAndView login(@ModelAttribute User user) {
    	  logger.info("Running " + this);
          return new ModelAndView("test/login");
      }
    
     /***   POST  ***/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView  connect(@ModelAttribute  User user, BindingResult result) throws Exception {
 
    	userValidator.validate(user, result);
        
    	if (result.hasErrors()) {
            return new ModelAndView("test/login");
        }
    	
    	if(userService.connect(new Integer(user.getId()), user.getPassword())){
    		this.user.setId(user.getId());
    		this.user.setPassword(user.getPassword());
    		
    		ModelAndView modelAndView = new ModelAndView("test/sucess");
    		
    		long id = new Integer(this.user.getId());
    		
    		Person person = personService.getPerson(id);
    		String name = person.getFirstname();
    		
    		modelAndView.addObject("name", name);
    		return modelAndView;
    	}
    	
       userValidator.validateAuthentification(false, result);
       return new ModelAndView("test/login");
    }
    
    
    /********************************************************
     *   				EDITION                             *
     *                                                      *
     ********************************************************/

    
    
      /******************   Service personne *******************/
    
    	@Autowired
    	IPersonService personService;
       
    	@Autowired
     	IGroupService groupService;
       
    	@Autowired
        PersonValidator personValidator;
    	
    	
    	 /***   Liste des groupes ***/	
    	 @ModelAttribute("groups")
    	    public Map<Integer, String> productTypes() {
    	        
    	    	Map<Integer, String> groups = new LinkedHashMap<>();
    	    	
    	        for(Group group: groupService.getAllGroups()){
    	        	 groups.put((int) group.getGroupID(), group.getName()); 	
    	        }
    	        return groups;
    	 }
    	
    	  /***   GET  ***/	
    	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
    	    public ModelAndView editGet(@ModelAttribute Person p) throws NumberFormatException, Exception {
    	        logger.info("Running " + this);
    	        
    	        Person userProfil = personService.getPerson(new Integer(user.getId()));
    			ModelAndView modelAndView = new ModelAndView("test/edit");
    			
    			modelAndView.addObject("firstname", userProfil.getFirstname());
    			modelAndView.addObject("lastname", userProfil.getLastname());
    			modelAndView.addObject("email", userProfil.getEmail());
    			
    			String date = new SimpleDateFormat("yyyy-MM-dd").format(userProfil.getBirthdate());
    			
    			modelAndView.addObject("birthdate", date);
    			
    			
    	        return modelAndView;
    	    } 
    
    	 
    	   /***   Post  ***/
    	 
    	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
    	    public ModelAndView editPost(@ModelAttribute Person person,  BindingResult result, HttpServletRequest request) 
    	    		throws NumberFormatException, Exception {
    	    	
    	    	personValidator.validate(person, result, request);
    	    	
    	    	if (result.hasErrors()) {
    	    		
    	    		Person userProfil = personService.getPerson(new Integer(user.getId()));
    	    		ModelAndView modelAndView = new ModelAndView("EditPerson");
    	    		
    	    		modelAndView.addObject("firsname", userProfil.getFirstname());
    	    		modelAndView.addObject("lastname", userProfil.getLastname());
    	    		modelAndView.addObject("email", userProfil.getEmail());
    	    		String date = new SimpleDateFormat("yyyy-MM-dd").format(userProfil.getBirthdate());
    	    		modelAndView.addObject("birthdate", date);
    	               
    	    		return modelAndView;
    	        }
    	    	
    	    	
    	    	
    	    	person.setId(new Integer(user.getId()));
    	    	
    	    	if(!request.getParameter("group_").isEmpty()){
    	    	    Group group =  groupService.getGroup(new Integer(request.getParameter("group_")));
    	    	    person.setGroup(group);
    	    	}
    	    	
    	    	String date_s = request.getParameter("date");
    			SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
    			Date birthdate = dt.parse(date_s);
    			
    	    	person.setBirthdate(birthdate);
    	    
    	    	personService.updatePerson(user, person);
    	        return  new ModelAndView("test/success_edit");
    	    }
    	 
    	 
    	 
    	 /********************************************************
    	  *   				User Service                         *
    	  *                   (Mail)                             *
    	  ********************************************************/ 
    	 
    	 
    	  /***   GET  ***/
    	 @RequestMapping(value = "/password", method = RequestMethod.GET)
    	 public ModelAndView passwordGet(@ModelAttribute UserService userService) throws NumberFormatException, Exception {
 	        logger.info("Running " + this);
 	        
 			ModelAndView modelAndView = new ModelAndView("test/password");
 			
 	        return modelAndView;
 	    } 
    	 
   	     /***   POST  ***/
    	 @RequestMapping(value = "/password", method = RequestMethod.POST)
    	 public ModelAndView passwordPost(@ModelAttribute UserService userService) throws NumberFormatException, Exception {
 	        logger.info("Running " + this);
 	        
 			ModelAndView modelAndView = new ModelAndView("test/success_pass");
 			
 			this.userService.sendUserPassword(new Integer(userService.getId()));
 	        return modelAndView;
 	    } 
}
