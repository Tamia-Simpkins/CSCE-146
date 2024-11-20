/*
 * Written by Tamia Simpkins
 */

public class LinkedBST <Fruit extends Comparable<Fruit>>{//Maybe not type fruit
	
	private class Node{ //Instant variables
		Fruit data;
		Node leftChild;
		Node rightChild;
		
		Node(Fruit aData) {
			this.data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//head
	public LinkedBST() {
		root = null;
	}
	
	//add Method
	public void add(Fruit aData) {
		if(root == null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	private Node add(Node aNode, Fruit aData) {
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//Go left
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//Go right
				aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	
	//remove method
	void remove(Fruit aData) {
		root = remove(root,aData);
	}
	private Node remove(Node aNode, Fruit aData) {
		//Find the node
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data)<0)
				aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)
			aNode.rightChild = remove(aNode.rightChild,aData);
		else//Found it
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			
			
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild,temp.data);
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
	
	boolean search(Fruit aData) {
		return search(root,aData);
	}
	
	private boolean search(Node aNode, Fruit aData) {
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data)<0)//Go left
			return search(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//Go right
				return search(aNode.rightChild,aData);
		else
			return true;
	}
	void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data);//Process
		printPreorder(aNode.leftChild);//Left
		printPreorder(aNode.rightChild);//Right
	}
	
	void printInorder()
	{
		printInorder(root);
	}
	private void printInorder(Node aNode) {
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);//Left
		System.out.println(aNode.data);//Process
		printInorder(aNode.rightChild);//Right
	}
	
	void printPostorder() {
		printPostorder(root);
	}
	private void printPostorder(Node aNode) {
		if(aNode == null)
			return;
		printPostorder(aNode.leftChild);//Left
		printPostorder(aNode.rightChild);//Right
		System.out.println(aNode.data);//Process
	}
}
