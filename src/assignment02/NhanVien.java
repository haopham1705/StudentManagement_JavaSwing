package assignment02;

import java.io.Serializable;

public class NhanVien implements Serializable {
	private String ID;
	private String Name;
	private int Age;
	private String Address;
	private String Email;
	private double Salary;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public NhanVien(String iD, String name, int age, String address, String email, double salary) {
		super();
		ID = iD;
		Name = name;
		Age = age;
		Address = address;
		Email = email;
		Salary = salary;
	}
	@Override
	public String toString() {
		return "NhanVien [ID=" + ID + ", Name=" + Name + ", Age=" + Age + ", Address=" + Address + ", Email=" + Email
				+ ", Salary=" + Salary + "]";
	}
	public NhanVien() {
		super();
	}
	

}
