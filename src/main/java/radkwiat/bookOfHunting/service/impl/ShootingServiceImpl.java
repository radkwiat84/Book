package radkwiat.bookOfHunting.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import radkwiat.bookOfHunting.models.Shooting;
import radkwiat.bookOfHunting.repository.ShootingRepository;
import radkwiat.bookOfHunting.service.ShootingService;

@Service("shootingService")
@Transactional
public class ShootingServiceImpl implements ShootingService {

	@Autowired
	ShootingRepository shootingRepository;
	
	@Override
	public List<Shooting> findAllShooting() {
		return shootingRepository.findAll();
	}

	@Override
	public Shooting findShootingById(int id) {
		return shootingRepository.findById(id);
	}

}
