package radkwiat.bookOfHunting.service;

import radkwiat.bookOfHunting.models.HuntingPlan;

public interface HuntingPlanService {

	public HuntingPlan findHuntingPlanById(int id);
	
	public HuntingPlan findHuntingPlanByHuntingSeason(String season);
	
	public void saveHuntingPlan(HuntingPlan huntingPlan);
	
	public HuntingPlan findHuntingPlanByCreationYear(int creationYear);
	
}
