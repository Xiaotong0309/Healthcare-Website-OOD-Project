package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
class PageController{

@RequestMapping(value="/index") 
public ModelAndView index(HttpServletRequest request, HttpServletResponse response){ 
	return new ModelAndView("login"); }
}