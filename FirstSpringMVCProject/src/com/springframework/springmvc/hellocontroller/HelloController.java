package com.springframework.springmvc.hellocontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller

public class HelloController {

	@RequestMapping("/welcome/{country}/{username}")
	public ModelAndView helloWorld(@PathVariable Map<String, String> pathVars) {
		String name = pathVars.get("username");
		String country = pathVars.get("country");
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		//modelAndView.addObject("welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
		modelAndView.addObject("welcome", "Hello "+name+". You are from "+country);
		
		return modelAndView;
	}
	
	@RequestMapping("/hi")
	public ModelAndView hiWorld() {
			
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		//modelAndView.addObject("welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
		modelAndView.addObject("welcome", "Hi World");
		
		return modelAndView;
	}


}
