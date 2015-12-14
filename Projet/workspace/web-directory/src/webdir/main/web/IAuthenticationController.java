package webdir.main.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import webdir.main.model.AuthenticationForm;

public interface IAuthenticationController {
	
	public ModelAndView printSignIn(@ModelAttribute AuthenticationForm form);
	
	public ModelAndView authenticate(@ModelAttribute AuthenticationForm form,
			BindingResult res) throws Exception;
}
