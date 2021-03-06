package webdirectory.main.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webdirectory.main.business.services.*;

@Controller()
@RequestMapping("*")
public class HomeController {

	protected final PersonService ps = new PersonService(); 
	
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView printHome(HttpServletRequest req) {
        logger.info("Running " + this);
        ps.init();
        return new ModelAndView("home", "x", 1);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest req) {
        logger.info("Running " + this);
        return new ModelAndView("home", "x", 2);
    }
    
    @RequestMapping(value = "/home/test", method = RequestMethod.GET)
    public ModelAndView test2(HttpServletRequest req) {
        logger.info("Running " + this);
        return new ModelAndView("home", "x", 3);
    }
}