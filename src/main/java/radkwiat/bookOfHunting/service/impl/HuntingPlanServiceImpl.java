package radkwiat.bookOfHunting.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import radkwiat.bookOfHunting.models.HuntingPlan;
import radkwiat.bookOfHunting.repository.HuntingPlanRepository;
import radkwiat.bookOfHunting.service.HuntingPlanService;
@Service("huntingPlanService")
@Transactional
public class HuntingPlanServiceImpl implements HuntingPlanService{

	@Autowired
	HuntingPlanRepository huntingPlanRepository;
	
	@Override
	public HuntingPlan findHuntingPlanById(int id) {
		return huntingPlanRepository.findById(id);
	}

	@Override
	public HuntingPlan findHuntingPlanByHuntingSeason(String season) {
		return huntingPlanRepository.findByHuntingSeason(season);
	}

	@Override
	public void saveHuntingPlan(HuntingPlan huntingPlan) {
		huntingPlanRepository.save(huntingPlan);		
	}

}
