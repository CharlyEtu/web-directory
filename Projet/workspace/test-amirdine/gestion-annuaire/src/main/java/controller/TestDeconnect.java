package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller()
public class TestDeconnect {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired()
    User user;

    @ModelAttribute("user")
    public User newUser() {
        return user;
    }
    
    @RequestMapping(value = "/deconnect.html", method = RequestMethod.GET)
    public ModelAndView sayHello() {
    	
        String now = "deconnexion";
        String test = user.getLogin();
        
        System.out.println(test);
        user.setId("0");
        user.setLogin("");
        user.setPassword("");
        logger.info("Running " + this);
        return new ModelAndView("Deconnexion", "now", now).addObject("test",test);
    }
}