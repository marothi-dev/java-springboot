package org.boot.controller;

import org.boot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		ModelAndView modelView = null;
		if (userForm.getUsername().isEmpty() || userForm.getPassword().isEmpty()) {
			model.addAttribute("error", "Please enter login details");
			modelView = new ModelAndView("welcome");
			modelView.addObject("error", "Please enter login details");
			modelView.addObject("error", "Please enter login details");
			return modelView;
		} else {

			modelView = new ModelAndView("login");
			modelView.addObject("user", userForm);
			return modelView;
		}
	}
}
