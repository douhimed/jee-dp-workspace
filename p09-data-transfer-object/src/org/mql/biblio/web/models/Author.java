package org.mql.biblio.web.models;

public class Author {

	private int id;
	private String name;
	private int yearBorn;

	public Author() {
	}

	public Author(String name, int yearBorn) {
		super();
		this.name = name;
		this.yearBorn = yearBorn;
	}

	public Author(int id, String name, int yearBorn) {
		super();
		this.id = id;
		this.name = name;
		this.yearBorn = yearBorn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", yearBorn=" + yearBorn + "]";
	}

}
