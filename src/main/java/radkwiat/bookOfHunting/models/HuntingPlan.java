package radkwiat.bookOfHunting.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class HuntingPlan {

	@Transient
	final String error = "Liczba osobników do odstrzału jest wymagana";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "huntingplan_id")
	private int id;
	
	@NotEmpty(message = "Rok planu jest wymagany")
	private String huntingSeason;
	
	private int creatingYear;
	
	@OneToMany(mappedBy="huntingPlan")
	private List<User> userList;
	
	
	// ==============DZIK================================================
	@NotEmpty(message = error)
	private String liczbaOdyncow;

	@NotEmpty(message = error)
	private String liczbaLoch;

	@NotEmpty(message = error)
	private String liczbaWarchlakow;

	@NotEmpty(message = error)
	private String liczbaPrzelatkow;

	@NotEmpty(message = error)
	private String liczbaWycinkow;
	
	
	
//=============================GETERY I SETERY===============================
	
	
	
	public int getId() {
		return id;
	}

	public int getCreatingYear() {
		return creatingYear;
	}

	public void setCreatingYear(int creatingYear) {
		this.creatingYear = creatingYear;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHuntingSeason() {
		return huntingSeason;
	}

	public void setHuntingSeason(String huntingSeason) {
		this.huntingSeason = huntingSeason;
	}

	public String getLiczbaOdyncow() {
		return liczbaOdyncow;
	}

	public void setLiczbaOdyncow(String liczbaOdyncow) {
		this.liczbaOdyncow = liczbaOdyncow;
	}

	public String getLiczbaLoch() {
		return liczbaLoch;
	}

	public void setLiczbaLoch(String liczbaLoch) {
		this.liczbaLoch = liczbaLoch;
	}

	public String getLiczbaWarchlakow() {
		return liczbaWarchlakow;
	}

	public void setLiczbaWarchlakow(String liczbaWarchlakow) {
		this.liczbaWarchlakow = liczbaWarchlakow;
	}

	public String getLiczbaPrzelatkow() {
		return liczbaPrzelatkow;
	}

	public void setLiczbaPrzelatkow(String liczbaPrzelatkow) {
		this.liczbaPrzelatkow = liczbaPrzelatkow;
	}

	public String getLiczbaWycinkow() {
		return liczbaWycinkow;
	}

	public void setLiczbaWycinkow(String liczbaWycinkow) {
		this.liczbaWycinkow = liczbaWycinkow;
	}

	public int getYear() {
		return creatingYear;
	}

	public void setYear(int year) {
		this.creatingYear = year;
	}

	
}
