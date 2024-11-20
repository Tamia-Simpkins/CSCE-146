/*
 * Written by Tamia Simpkins
 */

public class Process {
	private String Name;
	private double Ctime;
	
	public Process() {//Creating my instant variables
		this.Name = "none";
		this.Ctime = 0.0;
	}

	public Process(String aName, double aCtime) {//Parameterized Constructors
		this.setName(aName);
		this.setCompletionTime(aCtime);
	}
	public String getName() {//Accessor for Name
		return this.Name;
	}
	public double getCompletionTime() {//Accessor for Completion Time
		return this.Ctime;
	}
	public void setName(String aName) {
		if(aName!= null) {
			this.Name = aName;
		}
		else {
			this.Name = "none";//Setting my default values to null
		}
	}
	public void setCompletionTime(double aCtime) {
		if(aCtime > 0) {
			this.Ctime = aCtime;
		}
		else {
			this.Ctime = 0.0;//Setting my default values to null
		}
	}
	
	public String toString() {
		return "Process Name: "+this.Name+ " Completion Time: "+this.Ctime;
}

}
