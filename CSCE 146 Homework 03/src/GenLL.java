/*
 * Written by Tamia Simpkins
 */
public class GenLL <T>{
	private class ListNode
	{
		T data;
		ListNode link;
		
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode current;
	private ListNode previous;//Object behind the current
	private int size;
	public GenLL()
	{
		head = current = previous = null;
		this.size=0;
	}
	public void add(T aData)
	{
		if(contains(aData)) {
			System.out.println("Duplicate task: "+aData);
			return;
		}
		ListNode newNode = new ListNode(aData,null);
		if(head == null)
		{
			head = current = newNode;
			this.size=1;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
		this.size++;
	}
	public void remove(T aData) {
        if (head == null) return;
        
        if (head.data.equals(aData)) {
            head = head.link;
            return;
        }
        
        ListNode current = head;
        while (current.link != null) {
            if (current.link.data.equals(aData)) {
                current.link = current.link.link;
                return;
            }
            current = current.link;
        }
    }
	public void print() {
		ListNode temp = head;
		while(temp !=null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public void addAfterCurrent(T aData) {
		if(current == null) {
			return;
		}
		ListNode newNode = new ListNode(aData,current.link);
		current.link = newNode;
		this.size++;
	}
	public T getCurrent()
	{
		if(current == null) {
			return null;
		}
		return current.data;
	}
	public void setCurrent(T aData)
	{
		if(aData == null || current == null) {
			return;
		}
		current.data = aData;
	}
	public void goToNext() {
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
	public int getSize() {
		return size;
	}
	public T getAt(int index) {
		if(index <0 || index >=size) {
			return null;
		}
		ListNode temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.link;
		}
		return temp.data;	
	}
	public void setAt(int index, T aData) {
		if(index < 0 || index >= size || aData == null) {
			return;
		}
		ListNode temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.link;
		}
		temp.data = aData;
	}
	public boolean contains(T aData) {//Method to see if the list contains the Task
		ListNode current = head;
		while(current != null) {
			if(current.data.equals(aData)) return true;
			current = current.link;
		}
		return false;
	}
	public boolean isEmpty() {
        return size == 0; // Returns true if size is 0
}
}

