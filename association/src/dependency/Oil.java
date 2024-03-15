package dependency;

public class Oil {
	
	private String type;
	
	public Oil() {
		
	}

	public Oil(String type) {
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
		return "Oil [type=" + type + "]";
	}

	
	
}
