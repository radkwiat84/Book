package radkwiat.bookOfHunting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import radkwiat.bookOfHunting.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);
 
	public User findUserById(int id);
}
