package radkwiat.bookOfHunting.controllers;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@GET
	@RequestMapping("/")
	public String showIndexPage() {
		return "index";
	}
	

}
