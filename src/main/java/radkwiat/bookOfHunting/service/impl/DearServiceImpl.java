package radkwiat.bookOfHunting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import radkwiat.bookOfHunting.models.Dear;
import radkwiat.bookOfHunting.repository.DearRepository;
import radkwiat.bookOfHunting.service.DearService;

public class DearServiceImpl implements DearService{

	@Autowired
	DearRepository dearRepository;
	
	@Override
	public List<Dear> findAllDears() {
		return dearRepository.findAll();
	}

}
