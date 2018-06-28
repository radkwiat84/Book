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
@RequestMapping("/admin")
public class AdminPageController {

	@Autowired
	private UserService userService;

	@Autowired

	@GetMapping("/main")
	@Secured(value = { "ROLE_ADMIN" })
	public String showAdminPanel() {
		return "admin/admin";
	}

	@RequestMapping("/users")
	@Secured({ "ROLE_ADMIN" })
	public String getAllUsers(Model model) {

		List<User> userList = settingRolaInt();

		model.addAttribute("userList", userList);

		return "admin/users";
	}

	@GetMapping("/edit/{id}")
	@Secured({ "ROLE_ADMIN" })
	public String getUserToEdit(@PathVariable int id, Model model) {

		User user = new User();

		user = userService.findUserById(id);
		int rola = user.getRoles().iterator().next().getId();
		user.setRolaInt(rola);
		model.addAttribute("user", user);
		return "admin/useredit";
	}

	@PostMapping("/users/update")
	@Secured({ "ROLE_ADMIN" })
	public String updateUser(Model model, @Valid User user, BindingResult result) {

		String returnPage = null;
		String rola = null;

		if (user.getRolaInt() == 1) {
			rola = "ROLE_ADMIN";
		} else if (user.getRolaInt() == 3) {
			rola = "ROLE_UPUSER";
		} else {
			rola = "ROLE_USER";
		}

		if (result.hasErrors()) {
			returnPage = "admin/useredit";
		} else {

			userService.updateUsersRole(rola, user);

			List<User> userList = settingRolaInt();
			model.addAttribute("userList", userList);
			returnPage = "admin/users";
		}

		return returnPage;
	}

	@GetMapping("/changeuseractivity/{id}")
	@Secured({ "ROLE_ADMIN" })
	public String showDeactivationUserPage(@PathVariable int id, Model model) {

		User user = new User();
		user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "admin/usersActivity";
	}

	@PostMapping("/users/changedactivity")
	@Secured({ "ROLE_ADMIN" })
	public String changeActivityOfUser(Model model, User user) {

		userService.changeActivityOfUser(user);

		List<User> userList = settingRolaInt();
		model.addAttribute("userList", userList);
		return "admin/users";
	}

	@ModelAttribute("roleMap")
	public Map<Integer, String> roleMap() {
		Map<Integer, String> roleMap = new HashMap<>();
		roleMap.put(1, "Administrator");
		roleMap.put(2, "Myśliwy");
		roleMap.put(3, "Łowczy");
		return roleMap;
	}

	private List<User> settingRolaInt() {
		List<User> userList = userService.findAll();
		for (User users : userList) {
			users.setRolaInt(users.getRoles().iterator().next().getId());
		}
		return userList;
	}
}
