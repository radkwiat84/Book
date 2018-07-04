package radkwiat.bookOfHunting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import radkwiat.bookOfHunting.models.HuntingPlan;

@Repository("huntingPlanRepository")
public interface HuntingPlanRepository extends JpaRepository<HuntingPlan, Integer> {

	public HuntingPlan findById(int id);
	
	public HuntingPlan findByHuntingSeason(String season);
	
	public HuntingPlan findByCreatingYear(int creatingYear);
	
	
}
