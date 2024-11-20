/*
 * Written by Tamia Simpkins
 */
import java.io.File;
import java.util.Random;
import java.io.IOException;
import java.util.Scanner;
public class ShowcaseShowdown {

	public static final String FILE_NAME = "./prizeList.txt";//Creates String "FILE_NAME" and populates it with the text file content
	public static final String DELIM ="\t";//Creating my delimiter variable to split at "\t"
	public static String[] name;//Creating my name array.
	public static String[] price;//Creating my price array.
	public static int[] random = new int[5];
	public static String[] randname = new String[5];
	public static int[] randprice = new int[5];
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);//Construct the keyboard
	System.out.println("Welcome to the showcase show down!\nPlease type \"1\" to play or \"9\" to quit!");
		boolean quit = false;
		while(!quit)//Runs until the user quits
		{
			int pick = keyboard.nextInt();
			readname(FILE_NAME);//Calling readname and passing String FILLE_NAME through it
			readprice(FILE_NAME);//Calling readprice and passing String FILE_NAME through it
			Random();
			Randomselection();
			switch(pick)
			{
			case 1: //Run through add method
				Guess(Prize());
				System.out.println("If you like to play again enter \"1\" if you'd like to quit enter \"9\"");
				break;
			case 9:
				quit = true;
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid input");
			}
		}
	}
	
	public static void readname(String fileName)//readname method
	{
		try
		{
			//Creates a scanner for the file and then first counts each word
			Scanner fileScanner = new Scanner(new File(fileName));
			int wordCount = 0;//Setting wordCount to 0
			while(fileScanner.hasNextLine())//While the file has a next line
			{
				String[] arr = fileScanner.nextLine().split(DELIM);
				if(arr.length == 2)
				{				
				wordCount++;
				}
			}
			fileScanner.close();//Closing my array
			//Creates the return array, resets the file scanner, and populates the array
			String[] retArr = new String[wordCount];//Creating a new array the size of the wordCount
			name = new String[wordCount];//Array for price
			fileScanner = new Scanner(new File(fileName));//Creating a new scanner to scan the file
			int index =0;
			while(fileScanner.hasNextLine())
			{
				String[] arr = fileScanner.nextLine().split(DELIM);
				if(arr.length == 2) {
					name[index] = arr[0];
					index++;
				}
			}
			fileScanner.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public static void readprice(String fileName)
	{
		try
		{
			//Creates a scanner for the file and then first counts each word
			Scanner fileScanner = new Scanner(new File(fileName));
			int wordCount = 0;//Setting wordCount to 0
			while(fileScanner.hasNextLine())//While the file has a next line
			{
				String[] arr = fileScanner.nextLine().split(DELIM);
				if(arr.length == 2)
				{				
				wordCount++;
				}
			}
			fileScanner.close();//Closing my array
			//Creates the return array, resets the file scanner, and populates the array
			String[] retArr = new String[wordCount];//Creating a new array the size of the wordCount
			price = new String[wordCount];//Array for price
			fileScanner = new Scanner(new File(fileName));//Creating a new scanner to scan the file
			int index =0;
			while(fileScanner.hasNextLine())
			{
				String[] arr = fileScanner.nextLine().split(DELIM);
				if(arr.length == 2) {
					price[index] = arr[1];
					index++;
				}
			}
			fileScanner.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void Random()//Method to create an array with 5 randomly chosen values capped at the name array
	{
		Random r = new Random();//Making a new random called r
		for(int i=0; i< random.length;i++)
		{
			int temp;//Making a temp int value
			boolean unique;//Used to check if the int chosen is unique
			
			do {
				temp = r.nextInt(name.length);
				unique = true;
				
				for(int j=0;j< i; j++) {
					if(random[j] == temp) {
						unique = false;
						break;
					}
				}
			}
			while(!unique);
			random[i] = temp;//Setting random at index i to the temp value
		}
	}
	
	public static void Randomselection()
	{
		int[] intprice = new int[price.length];//Creating a new array length price

		for (int i = 0; i < price.length; i++) {
		    intprice[i] = Integer.parseInt(price[i]);//Converting the values in price to integers
		}

		for(int j=0; j<random.length;j++)//
		{
			randname[j] = name[random[j]];
			randprice[j] = intprice[random[j]];
		}
	}
	
	public static int Prize()
	{
		System.out.println("Your prizes are:");
		for(int q=0;q<random.length;q++)
		{
			System.out.println(randname[q]);
		}
		System.out.println("You must guess the total cost of the prizes\nwithout going over and within $1,300 of it's actual price");
		System.out.println("Enter your guess");
		Scanner keyboard = new Scanner(System.in);
		int guess = keyboard.nextInt();
		return guess;
	}
	
	public static void Guess(int guess)
	{
		int totalprice = 0;
		for(int i=0;i<randprice.length;i++)
		{
		totalprice += randprice[i];
		}

		if(guess > totalprice) {
			System.out.println("The actual cost was "+totalprice+"\nYour guess was over. You lose! :(");
		}
		else if(guess == totalprice) {
			System.out.println("YOU WERE SPOT ON!! CONGRATULATIONS YOU WIN!!! :D");
		}
		else if(Math.abs(guess - totalprice) <= 1300) {
			System.out.println("The actual cost was "+totalprice+"\nYou win!! :D");
		}
		else {
			System.out.println("The actual cost was "+totalprice+"\nYou guessed too low :(! You lose! :(");
		}
	}
	

}
