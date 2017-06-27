package com.springframework.springmvc.studentadmissioncontroller;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", 
							defaultValue="Mrs. Prasanna Lakshmi") String name, 
							@RequestParam("studentHobby") String hobby) {
		Student student1 = new Student();
		student1.setStudentName(name);
		student1.setStudentHobby(hobby);
		
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("headerMessage", "Prasanna Lakshmi College of Engineering , India");
		modelAndView.addObject("msg", "Details submitted by you :: Name "+name+" , Hobby : "+hobby);
		modelAndView.addObject("student1", student1);
		
		return modelAndView;
	}

}
	


