package radkwiat.bookOfHunting.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import radkwiat.bookOfHunting.models.User;
import radkwiat.bookOfHunting.service.UserService;

@Controller
public class AdminPageController {

	@Autowired
	private UserService userService;

	@GetMapping("/admin/main")
	@Secured(value = { "ROLE_ADMIN" })
	public String showAdminPanel() {
		return "admin/admin";
	}

	@RequestMapping("/admin/users")
	@Secured({ "ROLE_ADMIN" })
	public String getAllUsers(Model model) {
		List<User> userList = userService.findAll();

		settingRolaInt(userList);

		model.addAttribute("userList", userList);

		return "admin/users";
	}

	@GetMapping("/admin/edit/{id}")
	@Secured({ "ROLE_ADMIN" })
	public String getUserToEdit(@PathVariable("id") int id, Model model) {

		User user = new User();
		
		user = userService.findUserById(id);
		int rola = user.getRoles().iterator().next().getId();
		user.setRolaInt(rola);
		model.addAttribute("user", user);
		return "admin/useredit";
	}

	@ModelAttribute("roleMap")
	public Map<Integer, String> roleMap() {
		Map<Integer, String> roleMap = new HashMap<>();
		roleMap.put(1, "Administrator");
		roleMap.put(2, "Użytkownik");
		return roleMap;
	}
	
	
	@PostMapping("/admin/update")
	@Secured({ "ROLE_ADMIN" })
	public String updateUser(Model model, @Valid User user, BindingResult result) {

		String returnPage = null;
		String rola = null;

		if (user.getRolaInt() == 1) {
			rola = "ROLE_ADMIN";
		} else {
			rola = "ROLE_USER";
		}

		if (result.hasErrors()) {
			returnPage = "admin/useredit";
		} else {

			userService.updateUser(rola, user);

			List<User> userList = userService.findAll();

			settingRolaInt(userList);

			model.addAttribute("userList", userList);
			returnPage = "admin/users";
		}

		return returnPage;
	}

	
	
	private void settingRolaInt(List<User> userList) {
		for (User users : userList) {
			int numberOfRole = users.getRoles().iterator().next().getId();

			if (numberOfRole == 1) {
				users.setRolaInt(numberOfRole);
			} else if (numberOfRole == 2) {
				users.setRolaInt(numberOfRole);
			}
		}
	}

}
