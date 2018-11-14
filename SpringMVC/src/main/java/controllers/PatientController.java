package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import healthcare.Patient;
@Controller
public class PatientController {
	@RequestMapping(value="/login")
	/*
    
    
    public ModelAndView personPage() {
        return new ModelAndView("/login", "person-entity", new Patient());
    }
    */
    public String login(@RequestParam("id") String id, @RequestParam("password") String password,Model model){
    	if (id.equals(password)) 
    	{
    		model.addAttribute("id", id);
    		return "patient_homepage";
    	} else {
    		return "patient_homepage";
    	}
    }
    
    @RequestMapping(value="/process-person")
    public ModelAndView processPerson(@ModelAttribute Patient patient) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("patient_homepage");
         
        modelAndView.addObject("patients", patient);
         
        return modelAndView;
    }   
}
