package radkwiat.bookOfHunting.controllers;

import java.time.LocalDateTime;
import java.time.Year;
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

import radkwiat.bookOfHunting.models.Boar;
import radkwiat.bookOfHunting.models.Dear;
import radkwiat.bookOfHunting.models.HuntingPlan;
import radkwiat.bookOfHunting.models.Shooting;
import radkwiat.bookOfHunting.models.User;
import radkwiat.bookOfHunting.repository.BoarRepository;
import radkwiat.bookOfHunting.repository.DearRepository;
import radkwiat.bookOfHunting.repository.HuntingPlanRepository;
import radkwiat.bookOfHunting.repository.ShootingRepository;
import radkwiat.bookOfHunting.service.HuntingPlanService;
import radkwiat.bookOfHunting.service.ShootingService;
import radkwiat.bookOfHunting.service.UserService;

@Controller
@RequestMapping("/lowczy")

public class LowczyPageController {

	@Autowired
	HuntingPlanRepository huntingPlanRepository;

	@Autowired
	UserService userService;

	@Autowired
	HuntingPlanService huntingPlanService;

	@Autowired
	ShootingService shootingService;

	@Autowired
	ShootingRepository shootingRepository;

	@Autowired
	BoarRepository boarRepository;

	@Autowired
	DearRepository dearRepository;

	@GetMapping("/huntingplan/create")
	@Secured({ "ROLE_LOWCZY" })
	public String huntingPlanCreate(Model model) {
		String season = getSeasonToCreateHuntnigPlan();
		HuntingPlan isSeasonExist = huntingPlanService.findHuntingPlanByHuntingSeason(season);
		if (isSeasonExist != null) {
			model.addAttribute("message", "Plan polowań na sezon " + season + " został już stworzony.");
			return "index";
		}
		model.addAttribute("huntingPlan", new HuntingPlan());
		return "lowczy/huntingPlanCreate";

	}

	@PostMapping("/huntingplan/created")
	@Secured({ "ROLE_LOWCZY" })
	public String huntingPlaneCreated(Model model, @Valid HuntingPlan huntingPlan, BindingResult result) {
		String season = getSeasonToCreateHuntnigPlan();
		if (result.hasErrors())
			return "lowczy/huntingPlanCreate";
		else
			huntingPlanService.saveHuntingPlan(huntingPlan);
		model.addAttribute("message", "Plan na sezon łowiecki " + season + " został poprawnie utworzony.");

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
		HuntingPlan huntingPlan = huntingPlanService.findHuntingPlanById(id);
		model.addAttribute("huntingPlan", huntingPlan);
		return "lowczy/huntingPlan";
	}

	@GetMapping("/huntingplan/update/{id}")
	@Secured({ "ROLE_LOWCZY" })
	public String editHuntinPlan(Model model, @PathVariable int id) {
		HuntingPlan huntingPlan = huntingPlanService.findHuntingPlanById(id);
		model.addAttribute("huntingPlan", huntingPlan);
		return "lowczy/huntingPlanEdit";
	}

	@PostMapping("huntingplan/updated")
	@Secured({ "ROLE_LOWCZY" })
	public String editedHuntingPlan(Model model, @Valid HuntingPlan huntingPlan, BindingResult result) {
		if (result.hasErrors())
			return "lowczy/huntingPlanEdit";
		huntingPlanService.saveHuntingPlan(huntingPlan);
		List<HuntingPlan> huntingPlanList = huntingPlanRepository.findAll();
		model.addAttribute("huntingPlanList", huntingPlanList);
		model.addAttribute("updateMessage",
				"Poprawnie edytowano plan łowiecki na sezon " + huntingPlan.getHuntingSeason() + ".");
		return "lowczy/huntingPlans";
	}

	@GetMapping("/huntingplan/current")
	@Secured({ "ROLE_LOWCZY" })
	public String showCurrentHuntingPlan(Model model) {

		HuntingPlan huntingPlan = new HuntingPlan();
		huntingPlan = huntingPlanService.findHuntingPlanByCreationYear(findOutCurrentHuntingPlan());
		model.addAttribute("huntingPlan", huntingPlan);
		return "lowczy/huntingPlan";
	}

	@RequestMapping("/userslist")
	@Secured({ "ROLE_LOWCZY" })
	public String showUsersList(Model model) {
		List<User> usersList = new ArrayList<>();
		usersList = userService.findAll();
		model.addAttribute("usersList", usersList);
		return "lowczy/usersList";
	}

	@RequestMapping("/shootinglist")
	@Secured({ "ROLE_LOWCZY" })
	public String showShootingsList(Model model) {
		List<Shooting> shootingList = new ArrayList<>();
		shootingList = shootingService.findAllShooting();
		model.addAttribute("shootingList", shootingList);
		return "lowczy/shootingsList";
	}

	@GetMapping("/setshooting/{id}")
	@Secured({ "ROLE_LOWCZY" })
	public String setShooting(Model model, @PathVariable int id) {
		Boar boar = new Boar();
		Dear dear = new Dear();
		boar.setDzikToExecute(0);
		dear.setJelenToExecute(0);

		User user = userService.findUserById(id);

		Shooting shooting = new Shooting();
		shooting.setUser(user);
		shooting.setNameOfHunter(user.getName());
		shooting.setLastNameOfHunter(user.getLastName());
		shooting.setCity(user.getCity());
		shooting.setStreet(user.getStreet());
		shooting.setNumberOfBuilding(user.getNumberOfBuilding());
		shooting.setNumberOfApartment(user.getNumberOfApartment());
		shooting.setPostCode(user.getPostCode());

		model.addAttribute("shooting", shooting);
		model.addAttribute("boar", boar);
		model.addAttribute("dear", dear);
		return "lowczy/setShooting";
	}

	@PostMapping("/settedshooting")
	@Secured({ "ROLE_LOWCZY" })
	public String setedShooting(Model model, User user, Shooting shooting, Boar boar, Dear dear,
			 BindingResult resultShooting) {
		if (resultShooting.hasErrors())
			return "lowczy/setShooting";

		
		dearRepository.save(dear);
		boarRepository.save(boar);
		shootingRepository.save(shooting);

		model.addAttribute("message", "Poprawnie utworzono odstrzał dla myśliwego: " + shooting.getUser().getName()
				+ " " + shooting.getUser().getLastName());
		return "index";
	}

	@GetMapping("/openshooting/{id}")
	@Secured({ "ROLE_LOWCZY" })
	public String openShooting(Model model, @PathVariable int id) {
		Shooting shooting = shootingService.findShootingById(id);
		model.addAttribute("shooting", shooting);
		return "lowczy/openShooting";
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

	@ModelAttribute("season")
	public List<String> season() {
		List<String> season = new ArrayList<>();
		String seasonToCreate = getSeasonToCreateHuntnigPlan();
		season.add(seasonToCreate);
		return season;
	}

	private String getSeasonToCreateHuntnigPlan() {
		int year = Year.now().getValue();
		String season = "" + year + "/" + (year + 1);
		return season;
	}

	private Integer findOutCurrentHuntingPlan() {
		Integer yearOfCreatingHuntingPlan = null;

		int currentYear = Year.now().getValue();
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime startOfTheSeasonInFirstPart = LocalDateTime.parse(currentYear + "-04-01T00:00");
		LocalDateTime endOfTheSeasonInFirstPart = LocalDateTime.parse((currentYear + 1) + "-03-31T23:59:59.999");

		LocalDateTime startOfTheSeasonInSecondPart = LocalDateTime.parse((currentYear - 1) + "-04-01T00:00");
		LocalDateTime endOfTheSeasonInSecondPart = LocalDateTime.parse(currentYear + "-03-31T23:59:59.999");

		if (currentTime.isAfter(startOfTheSeasonInFirstPart) && currentTime.isBefore(endOfTheSeasonInFirstPart)) {
			yearOfCreatingHuntingPlan = currentYear;
		} else if (currentTime.isAfter(startOfTheSeasonInSecondPart)
				&& currentTime.isBefore(endOfTheSeasonInSecondPart)) {
			yearOfCreatingHuntingPlan = currentYear - 1;
		}
		return yearOfCreatingHuntingPlan;
	}

}
