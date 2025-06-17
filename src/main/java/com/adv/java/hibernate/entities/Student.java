package com.adv.java.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int id;
	
	@Column
	private String sName;
	
	@Column
	private int passoutYear;
	
	private Certificate certi;

	public Student(int id, String sName, int passoutYear, Certificate certi) {
		super();
		this.id = id;
		this.sName = sName;
		this.passoutYear = passoutYear;
		this.certi = certi;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sName=" + sName + ", passoutYear=" + passoutYear + ", certi=" + certi + "]";
	}

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public Student(int id, String sName, int passoutYear) {
		super();
		this.id = id;
		this.sName = sName;
		this.passoutYear = passoutYear;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getPassoutYear() {
		return passoutYear;
	}

	public void setPassoutYear(int passoutYear) {
		this.passoutYear = passoutYear;
	}

	
}
