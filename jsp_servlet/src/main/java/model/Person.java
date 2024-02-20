package model;

public class Person {
	String name;
	String age;
	Double height;
	
	public Person() {
		
	}
	
	public Person(String name, String age, Double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public Double getHeight() {
		return height;
	}



	public void setHeight(Double height) {
		this.height = height;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
}
