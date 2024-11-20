/*
 * Written by Tamia Simpkins
 */

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FruitTreeTester {
	
	public static final Scanner keyboard = new Scanner(System.in);
	static LinkedBST<Fruit> fruitTree = new LinkedBST<>();
	public static String DELIM = "\t";
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the fruit tree\nPlease enter a fruit File Name!");
		String file = keyboard.next();
		ReadFile(file, fruitTree);
		System.out.println("\n");
		System.out.println("Printing the pre-order traversal");
		fruitTree.printPreorder();
		
		System.out.println("\n");
		System.out.println("Printing the in-order traversal");
		fruitTree.printInorder();

		System.out.println("\n");
		System.out.println("Printing the post-order traversal");
		fruitTree.printPostorder();
		
		System.out.println("\n");

		System.out.println("Deleting: Type: Apple Weight: 0.4859853412170728");
		
		fruitTree.remove(new Fruit("Apple", 0.4859853412170728));
		
		
		System.out.println("\n");
		System.out.println("Printing the in-order traversal");
		fruitTree.printInorder();
	}
	
	
	public static void ReadFile(String file, LinkedBST<Fruit> fruitTree)
	{
		try {
			Scanner fileScanner = new Scanner(new FileInputStream(file));//Method to scan my file
			keyboard.nextLine();
		while(fileScanner.hasNextLine()) {
			String fileLine = fileScanner.nextLine();
			String [] splitLines = fileLine.split(DELIM);//Method to split my file based off of my DELIM
			
			if(splitLines.length == 2) {
				String fType = splitLines[0].trim();
				String fWeight = splitLines[1].trim();
				
			try {
				double weight = Double.parseDouble(fWeight);
				fruitTree.add(new Fruit(fType, weight));	
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid weight for fruit!");
			}
			}
		}
		fileScanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
