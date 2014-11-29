package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mk.ukim.finki.wp.json.CustomDateDeserializer;
import mk.ukim.finki.wp.json.ShortDateSerializer;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "persons")
public class Person extends BaseEntity {

	private String fistName;

	private String lastName;

	private String embg;

	private String foreignerSocalSecurityNumber;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonSerialize(using = ShortDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private DateTime birthDate;

	@ManyToOne
	private City city;

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmbg() {
		return embg;
	}

	public void setEmbg(String embg) {
		this.embg = embg;
	}

	public String getForeignerSocalSecurityNumber() {
		return foreignerSocalSecurityNumber;
	}

	public void setForeignerSocalSecurityNumber(
			String foreignerSocalSecurityNumber) {
		this.foreignerSocalSecurityNumber = foreignerSocalSecurityNumber;
	}

	public DateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
