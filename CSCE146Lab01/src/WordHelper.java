/*
 * Written by Tamia Simpkins
 */
import java.util.Scanner;
import java.io.*;
public class WordHelper {
	
public static String[] sortByVowels(String[] words)//Creating a class to sort the file by vowels
{
String[] Vowels = words.clone();//Clone Array
for(int i = 0; i< words.length; i++)//Initialized int at 0. Stops at words.length. i++ means everytime it goes through the loop i adds 1
{
	for(int j=0; j<Vowels[i].length(); j++)//Trying to get the words on their own
	{
		//Bubble Sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int s=0;s<Vowels.length-1;s++)
			{
				if(countvowels(Vowels[s]) > countvowels(Vowels[s+1]))//Passing vowels at index s through the countvowels method
				{
					//Swap
					String tempstring = Vowels[s];//Saving the value under a temp String to use to compare
					Vowels[s] = Vowels[s+1];
					Vowels[s+1] = tempstring;
					hasSwapped = true;
				}
			}
		}
	}
}
return Vowels;//Returning vowels.
}

public static String[] sortByConsonants(String[] words)//Inside parenthesis is the parameter
{
	String[] Consonants = words.clone();//Clone Array
	for(int i = 0; i< words.length; i++)//Initialized int at 0. Stops at words.length. i++ means everytime it goes through the loop i adds 1
	{
		for(int j=0; j<Consonants[i].length(); j++)//Trying to get the words on their own
		{
			//Bubble Sort
			boolean hasSwapped = true;
			while(hasSwapped)
			{
				hasSwapped = false;
				for(int s=0;s<Consonants.length-1;s++)
				{
					if(countcon(Consonants[s]) > countcon(Consonants[s+1]))//Passing consonants through the countcon method
					{
						//Swap
						String tempstring = Consonants[s];
						Consonants[s] = Consonants[s+1];
						Consonants[s+1] = tempstring;
						hasSwapped = true;
					}
				}
			}
		}
		}
	return Consonants;
	}
	
public static String[] sortByLength(String[] words)
{
	String[] Length = words.clone();//Clone Array
				//Bubble Sort
				boolean hasSwapped = true;
				while(hasSwapped)
				{
					hasSwapped = false;
					for(int i=0;i<Length.length-1;i++)//Using the .length string method to get the length of the array
					{
						if(Length[i].length() > Length[i+1].length())//Using .length string method to get the length of the array at index i
						{
							//Swap
							String temp = Length[i];
							Length[i] = Length[i+1];
							Length[i+1] = temp;
							hasSwapped = true;
						}
					}
				}
				return Length;
			}

public static int countvowels(String vowels)
{
	int countv = 0;
	for(int j = 0; j<vowels.length(); j++)//To go through the words in the array
	{
	if(vowels.charAt(j) == 'a' || vowels.charAt(j) == 'e' || vowels.charAt(j) == 'i' || vowels.charAt(j) == 'o' || vowels.charAt(j) == 'u' || vowels.charAt(j) == 'y')
		{
			countv++;
		}
	}	
	return countv;//Return updated vowel count for the word
}

public static int countcon(String consonants)
{
	int countc = 0;
	for(int j = 0; j<consonants.length(); j++)//To go through the words in the array
	{
	if(consonants.charAt(j) != 'a' && consonants.charAt(j) != 'e' && consonants.charAt(j) != 'i' && consonants.charAt(j) != 'o' && consonants.charAt(j) != 'u' && consonants.charAt(j) != 'y')//Must use && operator and not ||.
		{
			countc++;
		}
	}	
	return countc;//Return updated consonant count for the word
}
}
