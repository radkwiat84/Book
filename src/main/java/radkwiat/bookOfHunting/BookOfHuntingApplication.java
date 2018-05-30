package radkwiat.bookOfHunting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("radkwiat.bookOfHunting")
public class BookOfHuntingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookOfHuntingApplication.class, args);
	}
}
