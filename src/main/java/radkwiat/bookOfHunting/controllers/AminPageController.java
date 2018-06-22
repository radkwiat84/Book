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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import radkwiat.bookOfHunting.models.User;
import radkwiat.bookOfHunting.service.UserService;

@Controller
public class AminPageController {

	@Autowired
	private UserService userService;

	@RequestMapping("/admin/main")
	@Secured(value = { "ROLE_ADMIN" })
	public String showAdminPanel() {
		return "admin/admin";
	}

	@RequestMapping("/admin/users")
	@Secured({ "ROLE_ADMIN" })
	public String getAllUsers(Model model) {
		List<User> userList;
		userList = userService.findAll();

		for (User users : userList) {

			int numberOfRole = users.getRoles().iterator().next().getId();

			

			if (numberOfRole == 1) {
				users.setRolaInt(numberOfRole);
			} else if (numberOfRole == 2) {
				users.setRolaInt(numberOfRole);
			}
		}
		model.addAttribute("userList", userList);

		return "admin/users";
	}

	@RequestMapping("/admin/edit/{id}")
	@Secured({ "ROLE_ADMIN" })
	public String getUserToEdit(@PathVariable("id") int id, Model model) {

		User user = new User();
		/*
		 * automatyczne parsowanie w parametrach metody w adnotacji PathVariable
		 */
		// int userId = Integer.parseInt(id);
		user = userService.findUserById(id);

		Map<Integer, String> roleMap = new HashMap<>();
		roleMap.put(1, "Administrator");
		roleMap.put(2, "Użytkownik");

		int rola = user.getRoles().iterator().next().getId();

		user.setRolaInt(rola);

		model.addAttribute("roleMap", roleMap);
		model.addAttribute("user", user);

		return "admin/useredit";
	}

	@RequestMapping("/admin/update")
	@Secured({"ROLE_ADMIN"})
	public String updateUser(Model model, @Valid User user, BindingResult result) {

		String returnPage = null;
		String rola = null;

		if (user.getRolaInt() == 1) {
			rola = "ROLE_ADMIN";
		} else {
			rola = "ROLE_USER";
		}

		if (result.hasErrors()) {
			Map<Integer, String> roleMap = new HashMap<>();
			roleMap.put(1, "Administrator");
			roleMap.put(2, "Użytkownik");
			model.addAttribute("roleMap", roleMap);

			returnPage = "admin/useredit";
		} else {

			userService.updateUser(rola, user);

			List<User> userList = userService.findAll();

			for (User users : userList) {
				int numberOfRole = users.getRoles().iterator().next().getId();

				if (numberOfRole == 1) {
					users.setRolaInt(numberOfRole);
				} else if (numberOfRole == 2) {
					users.setRolaInt(numberOfRole);
				}
			}
			model.addAttribute("userList", userList);
			returnPage = "admin/users";
		}

		return returnPage;
	}

}
