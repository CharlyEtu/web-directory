package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;
import service.validator.UserValidator;

@Controller()

public class TestUserController{

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired()
    User user;

    @ModelAttribute("user")
    public User newUser() {
        return user;
    }
    
    @Autowired
    UserValidator userValidator;
    
	UserService userService = new UserService();
    
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView sayHello(@ModelAttribute User user) {
        logger.info("Running " + this);
        return new ModelAndView("Login");
    } 

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute  User user, BindingResult result) throws Exception {
 
    	
    	userValidator.validate(user, result);
        
    	if (result.hasErrors()) {
            return "Login";
        }
    	
    	if(userService.connect(new Integer(user.getId()), user.getPassword())){
    		this.user.setId(user.getId());
    		this.user.setPassword(user.getPassword());
    		return "Home";
    	}
    	
       userValidator.validateAuthentification(false, result);
       return "Login";
   }
        
}