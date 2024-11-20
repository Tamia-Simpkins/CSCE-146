/*
 * Tamia Simpkins
 */

public class DoubleDoubleLL {
	private class ListNode
	{
		double data;
		ListNode prev;
		ListNode link;
		
		public ListNode(double Adata)
		{
			this.data = Adata;
			this.prev = null;
			this.link = null;
		}
	}
	
	private ListNode head;
	private ListNode current;
	
	public DoubleDoubleLL()
	{
		head = current = null;
	}
	public void add(double aData)
	{
		ListNode newNode = new ListNode(aData);
		if(head == null) {
			head = newNode;
		}
		else {
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
		newNode.prev = temp;
	}
	}
	public void remove(double aData) {
		ListNode node = head;
        while (node != null) {
            if (node.data == aData) {
                if (node.prev != null) {
                    node.prev.link = node.link; // Link backward
                } else {
                    head = node.link; // Remove head
                }
                if (node.link != null) {
                    node.link.prev = node.prev; // Link forward
                }
                break; // Node found and removed
            }
            node = node.link;
        }
    }
	public void print() {
		ListNode temp = head;
		while(temp !=null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void addAfterCurrent(double aData) {
		if(current != null) {
			
		ListNode newNode = new ListNode(aData);
		newNode.link = current.link;
		newNode.prev = current;
		
		if(current.link != null) {
		current.link.prev = newNode;
		}
		
		current.link = newNode;
		
		}
	}
	public Double getCurrent()
	{
		if(current == null) {
			return null;
		}
		return current.data;
	}
	public void setCurrent(double aData)
	{
		if (current != null) {
            current.data = aData;
        }
    }
	public void gotoNext() {//Moves the current forward by one node
		if(current == null) {
			return;
		}
		current = current.link;
	}
	public void gotoPrev() {//Moves the current backwards by one node
		if(current == null) {
			return;
	}
		current = current.prev;
	}
		
	public void reset()//Moves the current to the head of the list.
	{
		current = head;
	}
	public void gotoEnd() {//Moves the current to the last node in the list
		if(head == null) {
			return;
		}
		current = head;
		while(current.link != null) {
			current = current.link;
		}
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public void removeCurrent() {
	    if (current != null) {
	        if (current.prev != null) {
	            current.prev.link = current.link; // Link backward
	        } else {
	            head = current.link; // Remove head
	        }
	        if (current.link != null) {
	            current.link.prev = current.prev; // Link forward
	        }
	        ListNode temp = current; // Save the current node
	        current = current.prev != null ? current.prev : head; // Move current to previous or head
	        temp = null; 
	    }
	}

	
	public boolean contains(double aData) {//Method to see if the list contains the Task
		 ListNode node = head;
	        while (node != null) {
	            if (node.data == aData) {
	                return true;
	            }
	            node = node.link;
	        }
	        return false;
	    }
}
