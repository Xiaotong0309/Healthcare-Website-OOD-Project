package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/l")
	public String login(Model model) {
		//model.addAttribute("firstName","Jinpeng");
		return "login";  
	}
}
