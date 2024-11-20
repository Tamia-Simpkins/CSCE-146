/*
 * Written by Tamia Simpkins
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class FileIOSolutions {
	
	public static final String DELIM = "\t";//Setting my DELIM
	public static final String DELIM2= " ";//Setting my 2nd DELIM
	public static final String FILE_NAME = "./ItIs.txt";//Creates String "FILE_NAME" and populates it with the text file content
	public static final String FILE_NAME2= "./ItWas.txt";
	public static final String FILE_NAME3= "./Tubes.txt";
	public static String[] Words; //Array for my words
	public static String[] Radius; //Array for my Radius
	public static String[] Height;//Array for my height


	
public static void pastTense(String string, String string2) {
List<String> words = new ArrayList<>();//Creating a new instance of an Array List.
{
	try
	{
		Scanner fileScanner = new Scanner(new File(FILE_NAME));//Creating a new instance of fileScanner.
		while(fileScanner.hasNextLine()) {//While my file has a next line...
			String line = fileScanner.nextLine();//Putting what is in the next line into the variable line
			Words = line.split(DELIM2);//Splitting the String Line with my DELIM and placing it into my array Words
			for(String word : Words) {//Puts every word in Words into my string word and iterates through it.
				if(!word.isEmpty()) {//This is to avoid adding empty strings. As long as my variable is empty add words.
					words.add(word);
				}
			}
		}
		fileScanner.close();//Closing my Scanner.
		}
	catch(IOException e)
	{
		System.out.println(e);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	try//This is for modifying is to was
	{
		String aName = "ItWas.txt";//Naming my file.
		PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));//Making a new print writer to create my new file.
		for(String word : words) {//For every variable in words put it into my string word and iterate through it.
			String modifiedWord = word.replaceAll("(?i)\\bis\\b", "was");//Replacing every instance of is to was regardeless of case.
			fileWriter.print(modifiedWord + " ");//This adds a space between words
								}
		fileWriter.close();//Closing my file writer.
	}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	try (Scanner fileScanner = new Scanner(new File(FILE_NAME2)))//This is for printing my new file
	{
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();//Putting what is in the next line into the variable line.
			String [] wordsline = line.split(DELIM2);//Splitting variable line with my DELIM2 and storing it in my array wordsline.
			for(String word : wordsline) {
				if(!word.isEmpty()) {
					System.out.println(word);
				}
			}		
										}
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
}
public static double totalTubeVolume(String string)//return double
{
	try
	{
		//Creates a scanner for the file and then first counts each word
		Scanner fileScanner = new Scanner(new File(FILE_NAME3));
		int wordCount = 0;//Setting wordCount to 0
		while(fileScanner.hasNextLine())//While the file has a next line
		{
			String[] arr = fileScanner.nextLine().split(DELIM);
			if(arr.length == 3)
			{				
			wordCount++;
			}
		}
		fileScanner.close();//Closing my array
		//Creates the return array, resets the file scanner, and populates the array
		String[] retArr = new String[wordCount];//Creating a new array the size of the wordCount
		Radius = new String[wordCount];//Array for price
		Height = new String[wordCount];
		fileScanner = new Scanner(new File(FILE_NAME3));//Creating a new scanner to scan the file
		int index =0;
		while(fileScanner.hasNextLine())
		{
			String[] arr = fileScanner.nextLine().split(DELIM);
			if(arr.length == 3) {
				Radius[index] = arr[1];
				Height[index] = arr[2];
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
	//Converting the Strings to doubles
	double[] doubleRadius = new double[Radius.length];//Creating a new array length price
	for (int i = 0; i < Radius.length; i++) {
	    doubleRadius[i] = Double.parseDouble(Radius[i]);//Converting the values in price to integers
	}
	double[] doubleHeight = new double[Height.length];//Creating a new array length price
	for (int i = 0; i < Height.length; i++) {
	    doubleHeight[i] = Double.parseDouble(Height[i]);//Converting the values in price to integers
	}
	//Performing my calculations
	double[] totalvolumearr = new double[doubleRadius.length];
	for(int i=0; i<doubleRadius.length; i++) {
	totalvolumearr[i] = Math.pow(doubleRadius[i], 2) * Math.PI * doubleHeight[i];
	}
	double totalvolume = 0;
	for(int i=0;i<totalvolumearr.length;i++)
	{
	totalvolume += totalvolumearr[i];
	}
	return totalvolume;
}
}