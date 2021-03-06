package radkwiat.bookOfHunting.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import radkwiat.bookOfHunting.models.Role;
import radkwiat.bookOfHunting.models.User;
import radkwiat.bookOfHunting.repository.RoleRepository;
import radkwiat.bookOfHunting.repository.UserRepository;
import radkwiat.bookOfHunting.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/*
	 * do modyfikacji poniższa metoda. Do rozważenia rola do nastawienia.  
	 */
	
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ROLE_MYSLIWY");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id);
	}

	//do możliwej modyfikacji (rozważyć jak przekazać argument do setRoles
	@Override
	public void updateUsersRole(String rola, User user) {
		Role userRole = roleRepository.findByRole(rola);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);

	}

	@Override
	public void changeActivityOfUser(User user) {
		if (user.getActive() == 1)
			user.setActive(0);
		else if(user.getActive() != 1)
			user.setActive(1);
		
		userRepository.save(user);
	}

}
