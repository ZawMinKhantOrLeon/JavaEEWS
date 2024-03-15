package manytomany;

import java.util.Set;

public class ManyToManyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher t1 = new Teacher(1L,"U Ba","Math");
		Teacher t2 = new Teacher(2L,"Aung Hein","Programming");
		Teacher t3 = new Teacher(3L,"Daw Kimuchi","Japanese");
		
		Student s1 = new Student(1L,"Mg Mg","IT");
		Student s2 = new Student(2L,"Kyaw Min","Math");
		Student s3 = new Student(3L,"Ma Sapal","Japanese");
		Student s4 = new Student(4L,"Zaw Zaw","Business");
		Student s5 = new Student(5L,"Kyaw Kyaw","Business");
		Student s6 = new Student(6L,"Aung Aung","Programming");
		Student s7 = new Student(7L,"Tun Tun","IT");
		Student s8 = new Student(8L,"Maung Maung","Math");
		Student s9 = new Student(9L,"Thu Zar","Japanese");
		Student s10 = new Student(10L,"Ye Ye","Math");
		
		// t1 <-> s8;
		t1.getStudents().add(s8);
		s8.getTeachers().add(t1);
		
		
		// t1 <-> s2;
		t1.getStudents().add(s2);
		s2.getTeachers().add(t1);
		
		// t1 <-> s8;
		t1.getStudents().add(s10);
		s10.getTeachers().add(t1);
		
		// t1 <-> s6;
		t1.getStudents().add(s6);
		s6.getTeachers().add(t1);
		
		//t2 <-> s6;
		t2.getStudents().add(s6);
		s6.getTeachers().add(t2);
		
		//t2 <-> s7;
		t2.getStudents().add(s7);
		s7.getTeachers().add(t2);
		
		//t2 <-> s1;
		t2.getStudents().add(s1);
		s1.getTeachers().add(t2);
		
		//t2 <-> s7;
		t2.getStudents().add(s7);
		s7.getTeachers().add(t2);
		
		//t3 <-> s3;
		t3.getStudents().add(s3);
		s3.getTeachers().add(t3);
		
		//t3 <-> s9;
		t3.getStudents().add(s9);
		s9.getTeachers().add(t3);
		
		//t3 <-> s6;
		t3.getStudents().add(s6);
		s6.getTeachers().add(t3);
		
		
		// students of t1
		
		System.out.println("t1's students : ");
		showAssociation(t1.getStudents());
		
		
		// students of t2
		
		System.out.println("t2's students : ");
		showAssociation(t2.getStudents());
		
		// students of t3
		
		System.out.println("t3's students : ");
		showAssociation(t3.getStudents());
		
		
	    // teacher of s1
		
		System.out.println("s1's teacher : ");
		showAssociation(s1.getTeachers());
		
		
		  // teacher of s2
	
		System.out.println("s2's teacher : ");
		showAssociation(s6.getTeachers());
 }
	
	static private void showAssociation(Set<?> TS) {
		
		 TS.forEach(System.out::println);
		 System.out.println();
	}

}
