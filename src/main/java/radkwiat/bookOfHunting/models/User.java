package radkwiat.bookOfHunting.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Email(message = "Podaj adres email")
	@NotEmpty(message = "Adres email jest wymagany")
	private String email;

	@Length(min = 5, message = "Minimalna ilość znaków = 5")
	@NotEmpty(message = "Hasło jest wymagane")
	private String password;

	@NotEmpty(message = "Podaj swoje imię")
	private String name;

	@NotEmpty(message = "Podaj swoje nazwisko")
	private String lastName;

	private int active;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Shooting> listOfShooting;
	
	@ManyToOne
	@JoinColumn(name="huntingplan_id")
	private HuntingPlan huntingPlan;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Boar> listOfBoars;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Dear> listOfDears;
	
	
	@Transient
	private int rolaInt; 
	
	@NotEmpty(message="Nazwa miasta jest wymagana.")
	private String city;

	@NotEmpty(message="Nazwa ulicy jest wymagana.")
	private String street;

	@NotEmpty(message="Numer budynku jest wymagany.")
	private String numberOfBuilding;

	private int numberOfApartment;

	@NotEmpty(message="Kod pocztowy jest wymagany.")
	private String postCode;
	
	
	
	//================================================GETERY I SETTERY================
	
	
	
	public int getRolaInt() {
		return rolaInt;
	}

	

	public List<Boar> getListOfBoars() {
		return listOfBoars;
	}



	public void setListOfBoars(List<Boar> listOfBoars) {
		this.listOfBoars = listOfBoars;
	}



	public HuntingPlan getHuntingPlan() {
		return huntingPlan;
	}

	public void setHuntingPlan(HuntingPlan huntingPlan) {
		this.huntingPlan = huntingPlan;
	}

	public int getNumberOfApartment() {
		return numberOfApartment;
	}

	public void setNumberOfApartment(int numberOfApartment) {
		this.numberOfApartment = numberOfApartment;
	}

	public List<Shooting> getListOfShooting() {
		return listOfShooting;
	}

	public void setListOfShooting(List<Shooting> listOfShooting) {
		this.listOfShooting = listOfShooting;
	}

	public HuntingPlan getHuntingplan() {
		return huntingPlan;
	}

	public void setHuntingplan(HuntingPlan huntingplan) {
		this.huntingPlan = huntingplan;
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

	public void setRolaInt(int rolaInt) {
		this.rolaInt = rolaInt;
	}

	public void setRolaInt(Integer rolaInt) {
		this.rolaInt = rolaInt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
