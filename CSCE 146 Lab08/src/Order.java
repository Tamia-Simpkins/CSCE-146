/*
 * Written by Tamia Simpkins
 */
public class Order implements Comparable <Order>{

	//Instance Variables
	private String Customer;
	private String FoodOrder;
	private int CookingTime;
	private int ArrivalTime;
	private int CookingTimeLeft;
	
	//Default Constructors
	public Order() {
		this.Customer = "none";
		this.FoodOrder = "none";
		this.CookingTime = 1;
		this.ArrivalTime = 0;
		this.CookingTimeLeft = this.CookingTime;
	}
	
	public Order(String aCustomer, String aFoodOrder, int aCookingTime, int aArrivalTime)
	{
		this.setCustomer(aCustomer);
		this.setFoodOrder(aFoodOrder);
		this.setCookingTime(aCookingTime);
		this.setArrivalTime(aArrivalTime);
		this.CookingTimeLeft = this.CookingTime;
	}
	
	//Accessors
	
	public String getCustomer() {
		return this.Customer;
	}
	public String getFoodOrder() {
		return this.FoodOrder;
	}
	public int getCookingTime() {
		return this.CookingTime;
	}
	public int getArrivalTime() {
		return this.ArrivalTime;
	}
	public int getCookingTimeLeft() {
		return this.CookingTimeLeft;
	}
	
	//Mutators
	
		public void setCustomer(String aC) {
			if(aC != null)
			this.Customer = aC;
			else
				this.Customer = "none";
		}
		
		public void setFoodOrder(String fO) {
			if(fO != null)
				this.FoodOrder = fO;
				else
					this.FoodOrder = "none";
		}
		
		public void setCookingTime(int cT) {
			if(cT > 0)
				this.CookingTime = cT;
				else
					this.CookingTime = 1;
		}
		
		public void setArrivalTime(int aT) {
			if(aT > 0)
				this.ArrivalTime = aT;
			else
				this.ArrivalTime = 0;
		}
		
		
		//Compare method
		public int compareTo(Order other) {
			return Integer.compare(this.CookingTime, other.CookingTime);
		}
		//Cooking methods
		public void cookForOneMinute()
		{
			if(CookingTimeLeft > 0)
			{
				CookingTimeLeft--;
			}
		}
		public boolean isDone()
		{
			return CookingTimeLeft == 0;
		}
		//String method
		public String toString()
		{
			return "Customer: " +this.Customer+ ", Order: " + this.FoodOrder + ", Cooking Time Left: " + this.CookingTimeLeft;
		}
}