package mk.ukim.finki.wp.model;

import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
