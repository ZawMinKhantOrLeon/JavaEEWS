package dependency;

public class Flavour {
	
	private String name;
	
	
	public Flavour() {
		
	}


	public Flavour(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Flavour [name=" + name + "]";
	}
	
	
}