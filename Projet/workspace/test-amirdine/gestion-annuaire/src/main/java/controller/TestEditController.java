package controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Group;
import model.Person;
import model.User;
import service.GroupService;
import service.IGroupService;
import service.IPersonService;
import service.validator.PersonValidator;

@Controller()
public class TestEditController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired()
    User user;

    @ModelAttribute("user")
    public User newUser() {
        return user;
    }
    
    @Autowired
	IPersonService personService ;
    
  	GroupService groupService = new GroupService();
    
    PersonValidator personValidator = new PersonValidator();
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	 dateFormat.setLenient(false);
             binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
             System.out.println("test");
    }
   
    
    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
    public ModelAndView sayHello(@ModelAttribute Person p) throws NumberFormatException, Exception {
        logger.info("Running " + this);
        
        Person userProfil = personService.getPerson(new Integer(user.getId()));
		ModelAndView modelAndView = new ModelAndView("EditPerson");
		
		modelAndView.addObject("firstname", userProfil.getFirstname());
		modelAndView.addObject("lastname", userProfil.getLastname());
		modelAndView.addObject("email", userProfil.getEmail());
		
		String date = new SimpleDateFormat("yyyy-MM-dd").format(userProfil.getBirthdate());
		
		modelAndView.addObject("birthdate", date);
		
		
        return modelAndView;
    } 
    
    
    @ModelAttribute("groups")
    public Map<Integer, String> productTypes() {
        
    	Map<Integer, String> groups = new LinkedHashMap<>();
    	
        for(Group group: groupService.getAllGroups()){
        	 groups.put((int) group.getGroupID(), group.getName()); 	
        }
        return groups;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute Person person,  BindingResult result, HttpServletRequest request) 
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
        return  new ModelAndView("Home");
    }
   
}