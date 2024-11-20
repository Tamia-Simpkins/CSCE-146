/*
 * Written by Tamia Simpkins
 */

public class Fruit implements Comparable <Fruit>{
	
	//Instance Variables
	private String Type;
	private double Weight;
	
	public Fruit() {//Default constructors
		this.Type = "apple";
		this.Weight = 1.0;
	}
	
	public Fruit(String aType, double aWeight) {//Parameterized constructors
		this.setType(aType);
		this.setWeight(aWeight);
	}
	
	//Acccessors
	public String getType() {
		return this.Type;
	}
	
	public double getWeight() {
		return this.Weight;
	}
	
	//Mutators
	public void setType(String aType) {
		if(aType.equalsIgnoreCase("apple") || aType.equalsIgnoreCase("orange") || aType.equalsIgnoreCase("banana") || aType.equalsIgnoreCase("kiwi") || aType.equalsIgnoreCase("tomato")) {
			this.Type = aType;
		}
		else {
			this.Type = "apple";
		}
	}
	public void setWeight(double aWeight) {
		if(aWeight > 0) {
			this.Weight = aWeight;
		}
		else
		{
			this.Weight = 1.0;
		}
	}
	
	public String toString() {
		return "Type: "+this.Type+" Weight: "+this.Weight;
	}
	
	public int compareTo(Fruit aFruit) {
		//Making sure fruit is populated
		if(aFruit == null) {
			return -1;
		}
		
		//Comparing the weights
		if(this.Weight > aFruit.Weight) {
			return 1;
		}
		else if(this.Weight < aFruit.Weight) {
			return -1;
		}
		else {
			return this.Type.compareToIgnoreCase(aFruit.Type);
		}
	}
}
