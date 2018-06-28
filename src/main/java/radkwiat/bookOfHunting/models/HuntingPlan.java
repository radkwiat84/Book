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
	@Column(name = "huntingplan_id")
	private int id;
	@NotEmpty(message="Rok planu jest wymagany")
	private short year;

	@NotEmpty(message="Liczba osobników do odstrzału jest wymagana")
	private short liczbaOdyncow;

	@NotEmpty(message="Liczba osobników do odstrzału jest wymagana")
	private short liczbaLoch;

	@NotEmpty(message="Liczba osobników do odstrzału jest wymagana")
	private short liczbaWarchlakow;

	@NotEmpty(message="Liczba osobników do odstrzału jest wymagana")
	private short liczbaPrzelatkow;

	@NotEmpty(message="Liczba osobników do odstrzału jest wymagana")
	private short liczbaWycinkow;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public short getLiczbaOdyncow() {
		return liczbaOdyncow;
	}

	public void setLiczbaOdyncow(short liczbaOdyncow) {
		this.liczbaOdyncow = liczbaOdyncow;
	}

	public short getLiczbaLoch() {
		return liczbaLoch;
	}

	public void setLiczbaLoch(short liczbaLoch) {
		this.liczbaLoch = liczbaLoch;
	}

	public short getLiczbaWarchlakow() {
		return liczbaWarchlakow;
	}

	public void setLiczbaWarchlakow(short liczbaWarchlakow) {
		this.liczbaWarchlakow = liczbaWarchlakow;
	}

	public short getLiczbaPrzelatkow() {
		return liczbaPrzelatkow;
	}

	public void setLiczbaPrzelatkow(short liczbaPrzelatkow) {
		this.liczbaPrzelatkow = liczbaPrzelatkow;
	}

	public short getLiczbaWycinkow() {
		return liczbaWycinkow;
	}

	public void setLiczbaWycinkow(short liczbaWycinkow) {
		this.liczbaWycinkow = liczbaWycinkow;
	}

}
