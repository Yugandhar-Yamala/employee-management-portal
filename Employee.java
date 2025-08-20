package com.naidu.p1;

public class Employee {
	private int id;
	private String name;
	private int salary;
	

	public Employee(int id2, String name2, int sal) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.name = name2;
		this.salary = sal;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString() {
		return id+" , "+name+" , "+salary;
	}
}