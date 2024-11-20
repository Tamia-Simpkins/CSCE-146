/*
 * Written by Tamia Simpkins
 */

import java.util.Scanner;

public class Sort {
	
    public static void main(String[] args) {
    	
        Scanner keyboard = new Scanner(System.in);
        GenLL inputStrings = new GenLL();

        do {
        	 inputStrings.reset();
            System.out.println("Enter any number of strings and I will sort by SORT’s. Once you’re done entering sentences enter \"quit\".");

            // reading input until "quit" is entered
            while (true) {
                String input = keyboard.nextLine();
                if (input.equalsIgnoreCase("quit")) {
                    break;
                }
                inputStrings.add(input);
            }

            // Convert linked list to array
            String[] strings = inputStrings.toArray();
            int stringCount = strings.length;

            // Count the amount of sorts
            int[] sortCount = new int[stringCount];
            for (int i = 0; i < stringCount; i++)
            {
                sortCount[i] = numofSorts(strings[i]);
            }

            // Sort strings based on the number of sorts
            mergeSort(strings, sortCount);
            
            // Printing the results
            System.out.println("sort SORTED!");
            for (int i = 0; i < strings.length; i++)
            {
                System.out.println(strings[i]);
            }
            
        } while (askToContinue(keyboard));

        System.out.println("Goodbye!");
    }

    // counting the number of sorts
    
    private static int numofSorts(String str) {
        String lowerString = str.toLowerCase();
        int count = 0;
        int index = 0;

        while ((index = lowerString.indexOf("sort", index)) != -1) {
            count++;
            index += 4; // move past the last found occurrence
        }
        return count;
    }

    private static void mergeSort(String[] strings, int[] counts) {
        
        if (counts.length <= 1) {
            return;
        }

        // splits the arrays into two
        int mid = counts.length / 2;
        String[] leftStrings = new String[mid];
        String[] rightStrings = new String[counts.length - mid];
        int[] leftCount = new int[mid];
        int[] rightCount = new int[counts.length - mid];

        // fill the left half
        for (int i = 0; i < mid; i++) {
            leftStrings[i] = strings[i];
            leftCount[i] = counts[i];
        }

        // fill the right half
        for (int i = mid; i < counts.length; i++) {
            rightStrings[i - mid] = strings[i];
            rightCount[i - mid] = counts[i];
        }
        
        mergeSort(leftStrings, leftCount);
        mergeSort(rightStrings, rightCount);

        // merge the sorted halves
        merge(strings, counts, leftStrings, leftCount, rightStrings, rightCount);
    }

    private static void merge(String[] strings, int[] counts, String[] leftStrings, int[] leftCounts, String[] rightStrings, int[] rightCounts) {
       
    	int i = 0, j = 0, k = 0;

        // merge the two arrays
        while (i < leftCounts.length && j < rightCounts.length) {
            if (leftCounts[i] <= rightCounts[j]) {
                strings[k] = leftStrings[i];
                counts[k] = leftCounts[i];
                i++;
            } else {
                strings[k] = rightStrings[j];
                counts[k] = rightCounts[j];
                j++;
            }
            k++;
        }

        while (i < leftCounts.length) {
            strings[k] = leftStrings[i];
            counts[k] = leftCounts[i];
            i++;
            k++;
        }

        while (j < rightCounts.length) {
            strings[k] = rightStrings[j];
            counts[k] = rightCounts[j];
            j++;
            k++;
        }
    }

    // ask user if they want to continue
    private static boolean askToContinue(Scanner scanner) {
        System.out.print("Would you like to sort more Strings? (Yes/No): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("Yes");
    }
}
