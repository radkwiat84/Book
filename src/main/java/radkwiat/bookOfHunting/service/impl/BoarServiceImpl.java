package radkwiat.bookOfHunting.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import radkwiat.bookOfHunting.models.Boar;
import radkwiat.bookOfHunting.repository.BoarRepository;
import radkwiat.bookOfHunting.service.BoarService;

@Service
@Transactional
public class BoarServiceImpl implements BoarService {

	@Autowired
	BoarRepository boarRepository;
	
	
	@Override
	public List<Boar> findAllBoars() {
		return boarRepository.findAll();
	}

}
