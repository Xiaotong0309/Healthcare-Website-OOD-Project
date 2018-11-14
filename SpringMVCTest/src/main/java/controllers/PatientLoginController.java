package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import healthcare.Patient;
@Controller
public class PatientLoginController {
	/*
	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("lll");
		//model.addAttribute("firstName","Jinpeng");
		return "login";  
	}
	@RequestMapping("patient_homepage")
    public ModelAndView login1(){ 
        System.out.println("login1() input");
        ModelAndView mav = new ModelAndView("login.spring");  
        return mav;
    }   
    //用于接收参数，并且返回到output页面
    @RequestMapping("login.spring")
    public ModelAndView login2(@RequestParam("id")String id,@RequestParam("password")String password){ 
        System.out.println(id);
        ModelAndView mav = new ModelAndView("patient_homepage");  
        mav.addObject("id",id);
        return mav;
    }  
*/
	
	@GetMapping("/login")
	public String login(Model model) {
		//model.addAttribute("firstName","Jinpeng");
		return "login";  
	}
	
	@RequestMapping(value="/login.spring", method = RequestMethod.POST)
	 public String login(String id, String password, Model model){
        if ("111".equals(id)) {
            System.out.println(" Success!");
            model.addAttribute("id",id);
            return "patient_homepage";
        }
        else {
        	System.out.println("Fail!");
        	model.addAttribute("id","Fail!");
        	return "patient_homepage";
        }
	}
	
	   
    
    /*
	@GetMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password,Model model){
    	if (id.equals(password)) 
    	{
    		model.addAttribute("id", id);
    		return "patient_homepage";
    	} else {
    		return "patient_homepage";
    	}
    	
    }
    */
	/*
	public ModelAndView personPage() {
		Patient patient = new Patient();
		
        return new ModelAndView("login", "login", patient);
    }
	
    @RequestMapping(value="/login.spring")
    public ModelAndView processPerson(@ModelAttribute Patient patient) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("patient_homepage");
         
        modelAndView.addObject("patient", patient);
         
        return modelAndView;
    }   
    */
    
 
}
