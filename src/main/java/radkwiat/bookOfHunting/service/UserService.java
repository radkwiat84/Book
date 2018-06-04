package radkwiat.bookOfHunting.service;

import radkwiat.bookOfHunting.models.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public void saveUser(User user);

}
