package radkwiat.bookOfHunting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import radkwiat.bookOfHunting.models.HuntingPlan;
import radkwiat.bookOfHunting.repository.HuntingPlanRepository;
import radkwiat.bookOfHunting.service.impl.HuntingPlanServiceImpl;

@Controller
@RequestMapping("/upuser/")
public class HuntingPlanController {

	@Autowired
	HuntingPlanRepository huntingPlanRepository;
	
	@Autowired
	HuntingPlanServiceImpl huntingPlanServiceImpl;

	@RequestMapping("/huntingplans")
	@Secured({ "ROLE_UPUSER" })
	public String showHuntingPlans(Model model) {
		List<HuntingPlan> huntingPlansList = huntingPlanRepository.findAll();
		model.addAttribute("huntingPlanList", huntingPlansList);
		return "upUser/huntingPlans";
	}

	@GetMapping("/huntingplan/{id}")
	@Secured({ "ROLE_UPUSER" })
	public String showHuntingPlan(Model model, @PathVariable int id) {
		HuntingPlan huntingPlan = huntingPlanServiceImpl.findHuntingPlanById(id);
		model.addAttribute("huntingPlan", huntingPlan);
		return "upUser/huntingPlan";
	}

	@PostMapping("huntingplan/updated")

	public String editHuntingPlan(Model model) {

		return "huntingPlanEdit";
	}
}
