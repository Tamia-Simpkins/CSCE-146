/*
 * Written by Tamia Simpkins
 */
class GenericQueue<T> {
	
    private ListNode<T> front;
    private ListNode<T> rear;

    private static class ListNode<T> {
    	
        T data;
        ListNode<T> link;

        ListNode(T data) {
        	
            this.data = data;
            this.link = null;
        }
    }

    public GenericQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        if (rear != null) {
            rear.link = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
    }

    public T dequeue() {
        if (front == null) {
            return null; 
        }
        T data = front.data;
        front = front.link;
        if (front == null) {
            rear = null; 
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = null; 
        rear = null;  
    }

}