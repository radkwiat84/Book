package radkwiat.bookOfHunting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class HuntingPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="huntigplan_id")
	private int id;

	@NotEmpty
	private int year;
	
	@NotEmpty
	private short liczbaLoch;
	
	@NotEmpty
	private short liczbaOdyńców;
	
	@NotEmpty
	private short liczbaWarchlaków;
	
	@NotEmpty
	private short liczbaPrzelatków;
	
	@NotEmpty
	private short liczbaWycinków;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public short getLiczbaLoch() {
		return liczbaLoch;
	}

	public void setLiczbaLoch(short liczbaLoch) {
		this.liczbaLoch = liczbaLoch;
	}

	public short getLiczbaOdyńców() {
		return liczbaOdyńców;
	}

	public void setLiczbaOdyńców(short liczbaOdyńców) {
		this.liczbaOdyńców = liczbaOdyńców;
	}

	public short getLiczbaWarchlaków() {
		return liczbaWarchlaków;
	}

	public void setLiczbaWarchlaków(short liczbaWarchlaków) {
		this.liczbaWarchlaków = liczbaWarchlaków;
	}

	public short getLiczbaPrzelatków() {
		return liczbaPrzelatków;
	}

	public void setLiczbaPrzelatków(short liczbaPrzelatków) {
		this.liczbaPrzelatków = liczbaPrzelatków;
	}

	public short getLiczbaWycinków() {
		return liczbaWycinków;
	}

	public void setLiczbaWycinków(short liczbaWycinków) {
		this.liczbaWycinków = liczbaWycinków;
	}
	

	
}
