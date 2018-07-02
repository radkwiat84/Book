package radkwiat.bookOfHunting.controllers;

import java.util.ArrayList;
import java.util.List;

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

import radkwiat.bookOfHunting.models.HuntingPlan;
import radkwiat.bookOfHunting.repository.HuntingPlanRepository;
import radkwiat.bookOfHunting.service.impl.HuntingPlanServiceImpl;

@Controller
@RequestMapping("/lowczy")
public class LowczyPageController {

	@Autowired
	HuntingPlanRepository huntingPlanRepository;

	@Autowired
	HuntingPlanServiceImpl huntingPlanServiceImpl;

	
	@GetMapping("/huntingplan/create")
	public String huntingPlanCreate(Model model) {
		model.addAttribute("huntingPlan", new HuntingPlan());
		return "lowczy/huntingPlanCreate";
	}

	@PostMapping("/huntingplan/created")
	public String huntingPlaneCreated(Model model, @Valid HuntingPlan huntingPlan, BindingResult result) {

		HuntingPlan isExist = huntingPlanServiceImpl.findHuntingPlanByHuntingSeason(huntingPlan.getHuntingSeason());
		if (isExist != null)
			result.rejectValue("huntingSeason", "errorHuntingPlan", "Podany plan na sezon łowiecki jest już stworzony.");
		if(result.hasErrors())
			return "lowczy/huntingPlanCreate";
		else
			huntingPlanServiceImpl.saveHuntingPlan(huntingPlan);
			model.addAttribute("message", "Plan na sezon łowiecki został poprawnie utworzony.");

		return "index";
	}

	
	@RequestMapping("/huntingplans")
	@Secured({ "ROLE_LOWCZY" })
	public String showHuntingPlans(Model model) {
		List<HuntingPlan> huntingPlansList = huntingPlanRepository.findAll();
		model.addAttribute("huntingPlanList", huntingPlansList);
		return "lowczy/huntingPlans";
	}

	@GetMapping("/huntingplan/{id}")
	@Secured({ "ROLE_LOWCZY" })
	public String showHuntingPlan(Model model, @PathVariable int id) {
		HuntingPlan huntingPlan = huntingPlanServiceImpl.findHuntingPlanById(id);
		model.addAttribute("huntingPlan", huntingPlan);
		return "lowczy/huntingPlan";
	}

	@GetMapping("/huntingplan/update/{id}")
	public String editHuntinPlan(Model model, @PathVariable int id) {
		HuntingPlan huntingPlan = huntingPlanServiceImpl.findHuntingPlanById(id);
		model.addAttribute("huntingPlan", huntingPlan);		
		return "lowczy/huntingPlanEdit";
	}
	
	
	@PostMapping("huntingplan/updated")
	public String editedHuntingPlan(Model model, @Valid HuntingPlan huntingPlan, BindingResult result) {
		
		if(result.hasErrors())
			return "lowczy/huntingPlanEdit";
		huntingPlanServiceImpl.saveHuntingPlan(huntingPlan);
		List <HuntingPlan> huntingPlanList = huntingPlanRepository.findAll();
		model.addAttribute("huntingPlanList", huntingPlanList);
		model.addAttribute("updateMessage", "Poprawnie edytowano plan łowiecki.");
		model.addAttribute("huntingPlan", huntingPlan);
		return "lowczy/huntingPlans";
	}

	@ModelAttribute("data")
	public List<String> fillingHuntinPlan() {
		List<String> data = new ArrayList<>();
		data.add("bez limitu");
		for (int i = 0; i <= 50; i++) {
			String j = Integer.toString(i);
			data.add(j);
		}
		return data;
	}

	@ModelAttribute("seasons")
	public List<String> seasons() {
		List<String> seasons = new ArrayList<>();
		seasons.add("2018/2019");
		seasons.add("2019/2020");
		seasons.add("2020/2021");
		seasons.add("2021/2022");
		return seasons;
	}

}
