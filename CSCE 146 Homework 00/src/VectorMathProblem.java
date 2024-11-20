/*
 * Written by Tamia Simpkins
 */
import java.util.Scanner;
public class VectorMathProblem {
	static Scanner keyboard;
	public static void main(String[] args) {
			keyboard = new Scanner(System.in);//Construct the keyboard

			boolean quit = false;
			while(!quit)//Runs until the user quits
			{
				Options();
				int pick = keyboard.nextInt();
				keyboard.nextLine();
				switch(pick)
				{
				case 1: //Run through add method
					addVectors();
					break;
				case 2:
					subtractVectors();
					break;
				case 3:
					magnitudeVectors();
					break;
				case 9:
					quit = true;
					break;
				default:
					System.out.println("Invalid input");
				}
			}
			System.out.println("Goodbye");
	}
	public static void Options()
	{
		System.out.println("Welcome to the Vector Math Problem");
		System.out.println("Enter 1: To add 2 Vectors\nEnter 2: To Subtract 2 Vectors\nEnter 3: To Find the Magnitude of a Vector\nEnter 9: To Quit");	
	}
	public static void addVectors()
	{
		System.out.println("Please enter the size of the vectors!");
		int ARRAY_SIZE = 0;//Initializing a variable for the array size.
		ARRAY_SIZE = keyboard.nextInt();//Setting the next int entered to be the array size.
		if(ARRAY_SIZE>0) {
		int[] vector1 = new int[ARRAY_SIZE];//Creating new array for vector 1
		int[] vector2 = vector1.clone();//Cloning the first array so they are the same size.
		int[] vector3= vector1.clone();
		System.out.println("Please enter the values for vector 1");
		for(int i=0;i<vector1.length;i++)//For loop assigns values for vector 1 array
		{
			vector1[i]= keyboard.nextInt();

		}
		System.out.println("Please enter the values for vector 2");
		for(int i=0;i<vector2.length;i++)//For loop assigns values for vector 1 array
		{
			vector2[i]= keyboard.nextInt();

		}
		for(int j=0; j< vector3.length;j++)
		{
			vector3[j] = vector1[j] + vector2[j];//Adding the values in vector 1 and vector 2 and storing them in vector 3
		}
		for(int k=0; k< vector3.length; k++)//Printing everything
		{
			System.out.println(vector1[k]);
		}
		System.out.println("+");
		for(int k=0; k< vector3.length; k++)
		{
			System.out.println(vector2[k]);
		}
		System.out.println("=");
		for(int k=0; k< vector3.length; k++)
		{
			System.out.println(vector3[k]);
		}
}
		else{
			System.out.println("That is not valid please enter a number greater than 0.");
			return;
		}
	}
	public static void subtractVectors()
	{
		System.out.println("Please enter the size of the vectors!");
		int ARRAY_SIZE = 0;//Initializing a variable for the array size.
		ARRAY_SIZE = keyboard.nextInt();//Setting the next int entered to be the array size.
		if(ARRAY_SIZE>0) {
		int[] vector1 = new int[ARRAY_SIZE];//Creating new array for vector 1
		int[] vector2 = vector1.clone();//Cloning the first array so they are the same size.
		int[] vector3= vector1.clone();
		System.out.println("Please ente the values for vector 1");
		for(int i=0;i<vector1.length;i++)//For loop assigns values for vector 1 array
		{
			vector1[i]= keyboard.nextInt();

		}
		System.out.println("Please enter the values for vector 2");
		for(int i=0;i<vector2.length;i++)//For loop assigns values for vector 1 array
		{
			vector2[i]= keyboard.nextInt();

		}
		for(int j=0; j< vector3.length;j++)
		{
			vector3[j] = vector1[j] - vector2[j];//Adding the values in vector 1 and vector 2 and storing them in vector 3
		}
		for(int k=0; k< vector3.length; k++)//Printing everything
		{
			System.out.println(vector1[k]);
		}
		System.out.println("-");
		for(int k=0; k< vector3.length; k++)
		{
			System.out.println(vector2[k]);
		}
		System.out.println("=");
		for(int k=0; k< vector3.length; k++)
		{
			System.out.println(vector3[k]);
		}
	}
		else{
			System.out.println("That is not valid please enter a number greater than 0.");
			return;
		}
	}
	public static void magnitudeVectors()
	{
		System.out.println("Please enter the size of the vector!");
		int ARRAY_SIZE = 0;//Initializing a variable for the array size.
		ARRAY_SIZE = keyboard.nextInt();//Setting the next int entered to be the array size.
		if(ARRAY_SIZE>0) {
		int[] vector1 = new int[ARRAY_SIZE];//Creating new array for vector 1
		System.out.println("Please enter the values for the vector");
		for(int i=0;i<vector1.length;i++)//For loop assigns values for vector 1 array
		{
			vector1[i]= keyboard.nextInt();

		}
		for(int j=0;j<vector1.length;j++)
		{
			vector1[j]= vector1[j]*vector1[j];
		}
		int sum =0;
		for(int l=0;l<vector1.length;l++)
		{
			sum += vector1[l];
		}
		System.out.print("The magnitude is: "+Math.sqrt(sum)+"\n");
	}
	else{
		System.out.println("That is not valid please enter a number greater than 0.");
		return;
	}
	}
}