package radkwiat.bookOfHunting.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import radkwiat.bookOfHunting.models.User;
import radkwiat.bookOfHunting.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/adduser")
	public String registerUserAction(@Valid User user, BindingResult result, Model model) {
		String returnPage = null;
		
		User userExist = userService.findUserByEmail(user.getEmail());
		if(userExist != null) {
			result.rejectValue("email", "error.user", "Podany adres email jest już w bazie");
		}
		if(result.hasErrors()) {
			returnPage = "register";
		} else {
			userService.saveUser(user);
			model.addAttribute("message", "Rejestracja udana. Możesz się zalogować");
			model.addAttribute("user", new User());
			returnPage = "register";
		}
		return returnPage;
	}

}
