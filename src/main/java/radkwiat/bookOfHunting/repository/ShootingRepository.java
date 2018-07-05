package radkwiat.bookOfHunting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import radkwiat.bookOfHunting.models.Shooting;

public interface ShootingRepository extends JpaRepository<Shooting, Long> {

	public Shooting findById(int id);
}
