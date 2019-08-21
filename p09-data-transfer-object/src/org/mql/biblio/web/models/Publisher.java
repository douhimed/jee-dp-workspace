package org.mql.biblio.web.models;

public class Publisher {

	private int id;
	private String name;

	public Publisher() {
	}

	public Publisher(int id) {
		this.id = id;
	}

	public Publisher(String name) {
		super();
		this.name = name;
	}

	public Publisher(int id, String name) {
		this(id);
		this.name = name;
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

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}

}
