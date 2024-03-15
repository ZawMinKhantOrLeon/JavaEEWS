package manytomany;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	
	private Long id;
	private String name;
	private String subject;
	private Set<Student> students = new HashSet<Student>();
	public Teacher() {
		
	}

	public Teacher(Long id, String name, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}
	
	
}
