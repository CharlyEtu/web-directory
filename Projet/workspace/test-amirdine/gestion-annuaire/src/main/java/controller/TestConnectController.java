package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller()
public class TestConnectController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired()
    User user;

    @ModelAttribute("user")
    public User newUser() {
        return user;
    }
    
    @RequestMapping(value = "/connect/{param}.html", method = RequestMethod.GET)
    public ModelAndView sayHello(@PathVariable("param") String param) {
        String now = "connexion";
        user.setId("1");
        user.setLogin(param);
        user.setPassword("d8gfh");
        logger.info("Running " + this);
        return new ModelAndView("Connexion", "now", now);
    }
}