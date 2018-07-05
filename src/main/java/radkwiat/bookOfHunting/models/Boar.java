package radkwiat.bookOfHunting.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.NumberFormat;


@Entity
public class Boar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NumberFormat
	@Min(value=0)
	private int shootingDzik;
	
	@NumberFormat
	@Min(0)
	private int executedDzik;
	
	@NumberFormat
	@Min(0)
	private int shootingOdyniec;
	
	@NumberFormat
	@Min(0)
	private int executedOdyniec;
	
	@NumberFormat
	@Min(0)
	private int shootingLocha;
	
	@NumberFormat
	@Min(0)
	private int executedLocha;
	
	@NumberFormat
	@Min(0)
	private int shootingWarchlak;
	
	@NumberFormat
	@Min(0)
	private int executedWarchlak;
	
	@NumberFormat
	@Min(0)
	private int shootingPrzelatek;
	
	@NumberFormat
	@Min(0)
	private int executedPrzelatek;
	
	@NumberFormat
	@Min(0)
	private int shootingWycinek;
	
	@NumberFormat
	@Min(0)
	private int executedWycinek;
	//======================================GETERY SETERY===============

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShootingDzik() {
		return shootingDzik;
	}

	public void setShootingDzik(int shootingDzik) {
		this.shootingDzik = shootingDzik;
	}

	public int getExecutedDzik() {
		return executedDzik;
	}

	public void setExecutedDzik(int executedDzik) {
		this.executedDzik = executedDzik;
	}

	public int getShootingOdyniec() {
		return shootingOdyniec;
	}

	public void setShootingOdyniec(int shootingOdyniec) {
		this.shootingOdyniec = shootingOdyniec;
	}

	public int getExecutedOdyniec() {
		return executedOdyniec;
	}

	public void setExecutedOdyniec(int executedOdyniec) {
		this.executedOdyniec = executedOdyniec;
	}

	public int getShootingLocha() {
		return shootingLocha;
	}

	public void setShootingLocha(int shootingLocha) {
		this.shootingLocha = shootingLocha;
	}

	public int getExecutedLocha() {
		return executedLocha;
	}

	public void setExecutedLocha(int executedLocha) {
		this.executedLocha = executedLocha;
	}

	public int getShootingWarchlak() {
		return shootingWarchlak;
	}

	public void setShootingWarchlak(int shootingWarchlak) {
		this.shootingWarchlak = shootingWarchlak;
	}

	public int getExecutedWarchlak() {
		return executedWarchlak;
	}

	public void setExecutedWarchlak(int executedWarchlak) {
		this.executedWarchlak = executedWarchlak;
	}

	public int getShootingPrzelatek() {
		return shootingPrzelatek;
	}

	public void setShootingPrzelatek(int shootingPrzelatek) {
		this.shootingPrzelatek = shootingPrzelatek;
	}

	public int getExecutedPrzelatek() {
		return executedPrzelatek;
	}

	public void setExecutedPrzelatek(int executedPrzelatek) {
		this.executedPrzelatek = executedPrzelatek;
	}

	public int getShootingWycinek() {
		return shootingWycinek;
	}

	public void setShootingWycinek(int shootingWycinek) {
		this.shootingWycinek = shootingWycinek;
	}

	public int getExecutedWycinek() {
		return executedWycinek;
	}

	public void setExecutedWycinek(int executedWycinek) {
		this.executedWycinek = executedWycinek;
	}
	
	
}
