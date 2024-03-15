package dependency;

import java.util.Set;

public class ChickenCurry {
	
	private final Chicken chicken;
	private final Oil oil;
	private final Set<Flavour> flavours;

	
	
	public ChickenCurry(Chicken chicken, Oil oil, Set<Flavour> flavours) {
		super();
		this.chicken = chicken;
		this.oil = oil;
		this.flavours = flavours;
	}


	public void cook() {
		
		if(chicken == null) {
			System.out.println("chicken is require");
			return;
		}
		if(oil == null) {
			System.out.println("oil is require");
			return;
		}
		if(flavours == null || flavours.isEmpty() ) {
			System.out.println("flavour is require");
			return;
		}
		
		System.out.println("Chicken curry is cooked");
		System.out.println("Chicken : "+ chicken.getType());
		System.out.println("Oil : "+ oil.getType());
		
		System.out.println("Flavours : ");
		
		
		//flavours.forEach(f -> System.out.println(f.getName()));
		flavours.forEach(System.out::println);
		
		System.out.println();
		
	}
}
