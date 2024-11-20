/*
 * Tamia Simpkins
 */

public class GroceryList {
	private class ListNode
	{
		GroceryItem data;
		ListNode link;
		public ListNode() {
			this.data = null;
			this.link = null;
		}
		public ListNode(GroceryItem aData, ListNode aLink)//Parameterized Constructors
		{
			this.data = aData;
			this.link = aLink;
		}
	}
	//Instance Variables
	private ListNode head;
	private ListNode current;
	private ListNode previous;//Object behind the current

	public GroceryList()//Constructors
	{
		this.head = new ListNode();
		this.current = this.head;
		this.previous = null;
	}
	public void addItem(GroceryItem aData)
	{
		 if (aData == null) return;

	        ListNode newNode = new ListNode(aData, null);
	        if (head.data == null) { // If the list is empty
	            head = newNode;
	            current = head;
	        } else {
	            ListNode temp = head;
	            while (temp.link != null) {
	                temp = temp.link;
	            }
	            temp.link = newNode;
	        }
	}
	public void showList() {
		ListNode temp = head;
		while(temp !=null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void addAfterCurrent(GroceryItem aData) {
		 if (current == null || aData == null) return;

	        ListNode newNode = new ListNode(aData, current.link);
	        current.link = newNode;
	}
	public GroceryItem getCurrent()
	{
		if(current == null) {
			return null;
		}
		return current.data;
	}
	public void setCurrent(GroceryItem aData)
	{
		if(aData == null || current == null) {
			return;
		}
		current.data = aData;
	}
	public void gotoNext() {
		if(current == null) {
			return;
		}
		previous = current;
		current = current.link;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	
	public boolean hasMore()
	{
		return current != null;
	}
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.link;
			current = head;
		}
		else {
			previous.link = current.link;
			current = current.link;
		}
	}
	public boolean contains(GroceryItem item) {
		 ListNode temp = head;
	        boolean contains = false;
	        while(temp != null){
	            if(temp.data.equals(item)){
	                contains = true;
	                break;
	            }
	            temp = temp.link;
	        }
	        return contains;
    }
	public double totalCost()
	{
		double total = 0.0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.data != null) {
                total += temp.data.getValue(); // Assuming GroceryItem has a getPrice() method
            }
            temp = temp.link;
        }
        return total;
    }
	}
