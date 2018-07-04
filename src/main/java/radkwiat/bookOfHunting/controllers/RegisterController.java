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
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/adduser")
	public String registerUserAction(@Valid User user, BindingResult result, Model model) {
		
		User userExist = userService.findUserByEmail(user.getEmail());
		
		if(userExist != null) {
			result.rejectValue("email", "error.user", "Podany adres email jest już w bazie");
		}
		if(result.hasErrors()) {
			return "register";
		} else {
			userService.saveUser(user);
			model.addAttribute("message", "Rejestracja udana. Możesz się zalogować.");
			return "index";
		}
	}

}
