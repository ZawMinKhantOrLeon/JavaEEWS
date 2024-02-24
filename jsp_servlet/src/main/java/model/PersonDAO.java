package model;

import java.util.Arrays;
import java.util.List;

public final  class PersonDAO {
	
	private PersonDAO() {
		
	}
	
	public static List<Person> getPerson(){
		return Arrays.asList(
				new Person("MgMg","21",5.6),
				new Person("MgMg","22",5.6),
				new Person("MgMg","23",5.6),
				new Person("MgMg","24",5.6),
				new Person("MgMg","25",5.6)
				
				);
	}
}
