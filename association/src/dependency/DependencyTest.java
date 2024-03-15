package dependency;

import java.util.HashSet;
import java.util.Set;

public class DependencyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chicken burmeseChicken = new Chicken("BurmeseChicken");
		Oil peanutOil = new Oil("PeanutOil");
		Flavour salt = new Flavour("Salt");
		Flavour msg = new Flavour("MSG");
		Flavour colorFlavour= new Flavour("colorFlavour");
		
		Set<Flavour> flavours = new HashSet<Flavour>();
		
		flavours.add(salt);
		flavours.add(msg);
		flavours.add(colorFlavour);
		
		//Dependency Injection
		
		ChickenCurry chickenCurry = new ChickenCurry(burmeseChicken, peanutOil, flavours);
		chickenCurry.cook();
		
	}

}
