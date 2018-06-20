package radkwiat.bookOfHunting.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
