package com.example.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {

	private int id;
	private String name;
	private String Surname;
	private String email;

	public Person(int id, String name, String surname, String email) {
		super();
		this.id = id;
		this.name = name;
		Surname = surname;
		this.email = email;
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

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", Surname=" + Surname + ", email=" + email + "]";
	}

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "example", "example", "example"));
		list.add(new Person(2, "example", "example", "example"));
		list.add(new Person(2, "example", "example", "example"));
		list.add(new Person(9, "example", "example", "example"));

		Collections.sort(list, new Comparator<Person>() {
			public int compare(Person obj1, Person obj2) {
				if (obj1.id > obj2.id)
					return -1;
				else
					return 1;

			}
		});

		list.forEach(item -> System.out.println(item.getId()));
	}

	@Override
	public int compareTo(Person o) {
		if (this.id > o.id)
			return 1;
		else if (this.id < o.id)
			return -1;
		else
			return 0;
	}

}
