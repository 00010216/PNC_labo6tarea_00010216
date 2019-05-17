package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller //manda a llamar a los metodos
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;

	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll(); //llamando metodo
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		//mav.addObject("message","Hi");
		return mav;
	}
	
	@RequestMapping(value = "/formSearch", method = RequestMethod.POST)
	public ModelAndView formSearch(@RequestParam Integer cStudent) {
		ModelAndView mav = new ModelAndView();
		Student rstudent = null;
		try {
			rstudent = studentDao.findOne(cStudent);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(rstudent == null) {
			mav.addObject("message","The student id you are searching for doesn't exist");
		}else {
		mav.addObject("rstudent",rstudent);
		}
		mav.setViewName("searchresult");

		return mav;
	}
	
}