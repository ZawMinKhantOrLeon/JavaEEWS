package manytomany;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private Long id;
	private String name;
	private String major;
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	public Student() {
		
	}

	public Student(Long id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", major=" + major + "]";
	}

	
	
	
}
