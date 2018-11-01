package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("firstName", "Elizabeth");
		return "welcomeMessage";
	}
	
}

