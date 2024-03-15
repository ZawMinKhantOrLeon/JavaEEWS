package dependency;

public class Chicken {
	
	private String type;
	
	public Chicken() {
		
	}

	public Chicken(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Chicken [type=" + type + "]";
	}
	
	
}
