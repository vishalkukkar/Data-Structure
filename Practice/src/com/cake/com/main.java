package com.cake.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

	public static class Relationship {
		public String relation;
		public Person toPerson;
	}

	public static class Person {
		public String fromName;
		public List<Relationship> relationships;
	}

	public List<String> genRelationships(String[][] seqs, String from, String to) {
		Map<String, Person> persons = new HashMap<String, Person>();

		// build lookup
		for (String[] relation : seqs) {
			String fromNameLc = relation[0].toLowerCase();
			Person fromPerson = persons.get(fromNameLc);
			if (fromPerson == null) {
				fromPerson = new Person();
				persons.put(fromNameLc, fromPerson);
				fromPerson.fromName = relation[0];
				fromPerson.relationships = new ArrayList<Relationship>();
			}

			String toNameLc = relation[2].toLowerCase();
			Person toPerson = persons.get(toNameLc);
			if (toPerson == null) {
				toPerson = new Person();
				persons.put(toNameLc, toPerson);
				toPerson.fromName = relation[2];
				toPerson.relationships = new ArrayList<Relationship>();
			}

			Relationship relationship = new Relationship();
			relationship.relation = relation[1];
			relationship.toPerson = toPerson;
			fromPerson.relationships.add(relationship);
		}

		Person fromPerson = persons.get(from.toLowerCase());
		Person toPerson = persons.get(to.toLowerCase());
		if (fromPerson == null || toPerson == null)
			return null;

		List<String> steps = new ArrayList<String>();
		List<String> paths = new ArrayList<String>();
		findPath(fromPerson, toPerson, steps, paths);

		return paths;
	}

	public void findPath(Person curPerson, Person tarPerson, List<String> steps, List<String> paths) {
		steps.add(curPerson.fromName);
		if (tarPerson == curPerson) {
			paths.add(String.join(" ", steps));
		} else {
			for (Relationship relationship : curPerson.relationships) {
				steps.add(relationship.relation);
				findPath(relationship.toPerson, tarPerson, steps, paths);
				steps.remove(steps.size() - 1);
			}
		}
		steps.remove(steps.size() - 1);
	}

	public void run() {
		String[][] seqs = { { "bart", "brother", "lisa" }, { "bart", "son", "homer" }, { "marge", "wife", "homer" },
				{ "lisa", "daughter", "homer" } };

		System.out.println(genRelationships(seqs, "bart", "homer"));

	}

	public static void main(String[] args) {
		new main().run();
	}

}
