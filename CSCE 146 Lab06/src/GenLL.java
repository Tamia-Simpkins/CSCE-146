/*
 * Written by Tamia Simpkins
 */

// Node class for the linked list

public class GenLL {
	private Node head;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}


    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // method to convert linked list to an array
    public String[] toArray() {
        int size = size();
        String[] arr = new String[size]; //creating string array
        Node current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void reset() {
        head = null; 
}
}
