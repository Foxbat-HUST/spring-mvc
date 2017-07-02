package com.vn.nev.SpringMvcDemo.model;

public class Student {

	private int id;
	private String name;
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	private double gpa;
	private int rating;
	
	public Student(){
	}

	/**
	 * @param id
	 * @param name
	 * @param gpa
	 */
	public Student(int id, String name, double gpa,int rating) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.rating=rating;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{id=%d, name=%s, gpa=%s rating:%d}", id, name, gpa,rating);
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
