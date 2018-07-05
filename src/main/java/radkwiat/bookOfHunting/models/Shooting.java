package radkwiat.bookOfHunting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "shooting")
public class Shooting {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "shooting_id")
	int id;
	
	@NotEmpty
	private String identityNumberOfShooting;

	@NotEmpty
	private String nameOfHunter;

	@NotEmpty
	private String lastNameOfHunter;

	@NotEmpty
	private String city;

	@NotEmpty
	private String street;

	@NotEmpty
	private String numberOfBuilding;

	private int numberOfApartment;

	@NotEmpty
	private String postCode;
	
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	//===================================GETERY SETERY==================

	
	
	public int getId() {
		return id;
	}

	public int getNumberOfApartment() {
		return numberOfApartment;
	}

	public void setNumberOfApartment(int numberOfApartment) {
		this.numberOfApartment = numberOfApartment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentityNumberOfShooting() {
		return identityNumberOfShooting;
	}

	public void setIdentityNumberOfShooting(String identityNumberOfShooting) {
		this.identityNumberOfShooting = identityNumberOfShooting;
	}

	public String getNameOfHunter() {
		return nameOfHunter;
	}

	public void setNameOfHunter(String nameOfHunter) {
		this.nameOfHunter = nameOfHunter;
	}

	public String getLastNameOfHunter() {
		return lastNameOfHunter;
	}

	public void setLastNameOfHunter(String lastNameOfHunter) {
		this.lastNameOfHunter = lastNameOfHunter;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberOfBuilding() {
		return numberOfBuilding;
	}

	public void setNumberOfBuilding(String numberOfBuilding) {
		this.numberOfBuilding = numberOfBuilding;
	}

	public int getNumberOfAppartment() {
		return numberOfApartment;
	}

	public void setNumberOfAppartment(int numberOfAppartment) {
		this.numberOfApartment = numberOfAppartment;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
}
