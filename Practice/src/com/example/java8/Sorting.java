package com.example.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

	private static void sortEmployees(List<Employee> employees) {
		Collections.sort(employees, (left, right) -> left.getSalary().compareTo(right.getSalary()));
	}

	public static void main(String[] args) {
		final List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "EMP1", 400000l));
		employees.add(new Employee(102, "EMP2", 360000l));
		employees.add(new Employee(103, "EMP3", 800000l));
		employees.add(new Employee(104, "EMP4", 600000l));
		employees.add(new Employee(105, "EMP5", 500000l));

		System.out.println("*****Employees*****\n" + employees);

		sortEmployees(employees);

		System.out.println("*****SORTED BY SALARY*****\n" + employees);
	}
}
