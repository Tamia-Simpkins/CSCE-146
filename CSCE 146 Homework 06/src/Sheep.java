/*
 * Written by Tamia Simpkins
 */
public class Sheep implements Comparable <Sheep>{
	//Instance Variables
	private String Name;
	private int Stime;
	private int Atime;
	
	public Sheep(String Name, int Stime, int Atime) {
		this.Name = Name;
		this.Stime = Stime;
		this.Atime = Atime;
	}
	
	//Accessors
	public String getName()
	{
		return Name;
	}
	public int getStime()
	{
		return Stime;
	}
	public int getAtime() {
		return Atime;
	}
	
	//Compare method
	public int compareTo(Sheep other)
	{
		if(this.Stime != other.Stime)
		{
			return Integer.compare(this.Stime, other.Stime);
		}
		return this.Name.compareTo(other.Name);
	}
	//String method
	public String toString()
	{
        return "Name: "+Name+" Shear Time: "+Stime+" Arrival Time: "+Atime;
	}
}
