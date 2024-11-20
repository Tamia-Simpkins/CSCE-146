/*
 * Written by Tamia Simpkins
 */
import java.util.Objects;
public class Task {
	private String Action;
	private int Priority;
	
	public Task() {//Creating my instant variables
		this.Action = "none";
		this.Priority = 4;
	}

	public Task(String aAction, int aPriority) {//Parameterized Constructors
		this.setAction(aAction);
		this.setPriority(aPriority);
	}
	public String getAction() {//Accessor for Action
		return this.Action;
	}
	public int getPriority() {//Accessor for Priority
		return this.Priority;
	}
	public void setAction(String aAction) {
		if(aAction!= null) {
			this.Action = aAction;
		}
		else {
			this.Action = "none";//Setting my default values to null
		}
	}
	public void setPriority(int aPriority) {
		if(aPriority >= 0 && aPriority <=4 ) {
			this.Priority = aPriority;
		}
		else {
			this.Priority = 4;//Setting my default values to null
		}
	}
	//Override Method
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Task task = (Task) obj;
	    return Priority == task.Priority && Action.equals(task.Action);
	}

	//Override Method
	public int hashCode() {
	    return Objects.hash(Action, Priority);
	}
	
	public String toString() {
		return "[Task] Priority: "+this.Priority+" Task: "+this.Action;
}
}
