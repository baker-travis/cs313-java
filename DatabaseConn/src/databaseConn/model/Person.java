package databaseConn.model;

import java.sql.Date;

public class Person {
	private int id;
	private String name;
	private Date birth;
	
	public Person(int id, String name, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
