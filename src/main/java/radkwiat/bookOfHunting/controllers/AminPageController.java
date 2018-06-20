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
			
			/*
			 * I tutaj jest zmotka z tabelą JOIN => do analizy
			 * 
			 * Poniżej iterujemy w pętli po kolekcji typu SET
			 * można tego nie robić, ale trzeba zrobić podwójny for
			 * CHYBA :P
			 */
			
			int numberOfRole = users.getRoles().iterator().next().getId();
			
			/*
			 * tutaj analogicznie pobieram z kolekcji SET z JOINA nazwę
			 * roli użytkownika
			 */
			String nameOfRole = users.getRoles().iterator().next().getRole();

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
