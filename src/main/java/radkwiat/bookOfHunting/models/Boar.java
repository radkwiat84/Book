package radkwiat.bookOfHunting.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Boar extends Animals {

	private int dzikToExecute;
	private int executedDzik;
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	

	//
	// // ======================================GETERY SETERY===============
	//
	
	
	

	

	

	public int getExecutedDzik() {
		return executedDzik;
	}

	public int getDzikToExecute() {
		return dzikToExecute;
	}

	public void setDzikToExecute(int dzikToExecute) {
		this.dzikToExecute = dzikToExecute;
	}

	public void setExecutedDzik(int executedDzik) {
		this.executedDzik = executedDzik;
	}

	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	
}
