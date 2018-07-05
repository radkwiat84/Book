package radkwiat.bookOfHunting.service;

import java.util.List;

import radkwiat.bookOfHunting.models.Shooting;

public interface ShootingService {

	public List<Shooting> findAllShooting();
	
	public Shooting findShootingById(int id);
	
}
