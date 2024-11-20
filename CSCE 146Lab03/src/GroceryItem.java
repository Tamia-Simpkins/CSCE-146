/*
 * Written by Tamia Simpkins
 */
public class GroceryItem {
	private String Name;
	private Double Value;
	public GroceryItem() {//Creating my instant variables
		this.Name = "none";
		this.Value = 0.0;
	}
	public GroceryItem(String aName, Double aValue) {//Parameterized Constructors
		this.setName(aName);
		this.setValue(aValue);
	}
	public String getName() {//Accessor for Name
		return this.Name;
	}
	public Double getValue() {//Accessor for Value
		return this.Value;
	}
	public void setName(String aName) {
		if(aName!= null) {
			this.Name = aName;
		}
		else {
			this.Name = "none";//Setting my default values to null
		}
	}
	public void setValue(Double aValue) {
		if(aValue != null) {
			this.Value = aValue;
		}
		else {
			this.Value = 0.0;//Setting my default values to null
		}
	}
	public String toString() {
		return "Grocery Item Name: "+this.Name+" Value "+this.Value;
}
	public boolean equals(GroceryItem item){
        return item != null &&
                this.Name.equals(item.getName()) &&
                this.Value.equals(item.getValue());
    }
}


