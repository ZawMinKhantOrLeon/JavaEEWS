package onetoone;

public class Computer {
	
	private String model;
	private String brand;
	private MotherBoard motherboard;
	
	public Computer() {
		motherboard = new MotherBoard();
	}

	public Computer(String model, String brand,String serial,String mbModel) {
		super();
		this.model = model;
		this.brand = brand;
		motherboard = new MotherBoard(serial,mbModel);
	}
	
	public void powerOn() {
		System.out.println(brand + " " + model  + " computer is starting ");
		motherboard.bootup();
		System.out.println(brand + " " + model  + " computer is started ");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Computer [model=" + model + ", brand=" + brand + "]";
	}
	
	
}
