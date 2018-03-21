package com.example.java8;

final public class Employee {
	final private Integer employeeCode;
	final private String employeeName;
	final private Long salary;

	public Employee(Integer employeeCode, String employeeName, Long salary) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public Integer getEmployeeCode() {
		return employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Long getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "[" + employeeName + " " + salary + "]";
	}

}