package radkwiat.bookOfHunting.service;

import java.util.List;

import radkwiat.bookOfHunting.models.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public void saveUser(User user);
	
	public List<User> findAll();

}
