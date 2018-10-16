package radkwiat.bookOfHunting.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dear extends Animals{
	
	private int jelenToExecute;
	private int executedJelen;
	
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

// ======================================GETERY SETERY===============

	
	
	
	

	public int getJelenToExecute() {
		return jelenToExecute;
	}

	public void setJelenToExecute(int jelenToExecute) {
		this.jelenToExecute = jelenToExecute;
	}

	public int getExecutedJelen() {
		return executedJelen;
	}

	public void setExecutedJelen(int executedJelen) {
		this.executedJelen = executedJelen;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	

	
	

	

}
