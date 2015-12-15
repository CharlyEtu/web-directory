package controller;


import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Person;
import model.User;
import service.IPersonService;

@Controller()
public class TestPersonController {
	
	 @Autowired
	 IPersonService personService ;
	 
	 @Autowired()
	 User user;

	 @ModelAttribute("user")
	 public User newUser() {
	        return user;
	  }
	 
	  protected final Log logger = LogFactory.getLog(getClass());

	    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
	    public ModelAndView sayHello() {
	    
	     Collection<Person> persons = personService.getAllPersons();
	     return new ModelAndView("PersonList", "persons", persons).addObject(user);
	    }
	    
	  

}