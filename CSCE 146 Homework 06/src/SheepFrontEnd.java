/*
 * Written by Tamia Simpkins
 */
import java.io.FileInputStream;
import java.util.Scanner;

public class SheepFrontEnd {
	public static final Scanner keyboard = new Scanner(System.in);
	static MinHeap<Sheep> Heap = new MinHeap<>();//New instance of heap
	public static String DELIM = "\t";
	private static int arrivalC = 0;
	private static Sheep[] arrivalA = new Sheep[61];
	public static void main(String[] args) {

			System.out.println("Welcome to the Sheep Sheering Scheduler! Please enter the name of your file!");
			String file = keyboard.next();
			ReadFile(file);
			System.out.println("Schedule from the Provided File:");
			sheepShearing();
		}
		
		public static void ReadFile(String file)
		{
			try {
				Scanner fileScanner = new Scanner(new FileInputStream(file));//Method to scan my file
				keyboard.nextLine();
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String [] splitLines = fileLine.split(DELIM);//Method to split my file based off of my DELIM
				
				if(splitLines.length == 3) {
					String fName = splitLines[0].trim();
					String fSheerTime = splitLines[1].trim();
					String fArrivalTime = splitLines[2].trim();
					
				try {
					int fStime = Integer.parseInt(fSheerTime);
					int fAtime = Integer.parseInt(fArrivalTime);
					
					arrivalA[arrivalC++] = new Sheep(fName,fStime, fAtime);	
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid input!");
				}
				}
			}
			fileScanner.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		private static void sheepShearing() {
		    int currentTime = 0;

		    while (arrivalC > 0 || !Heap.isEmpty()) {
		        for (int i = 0; i < arrivalC; i++) {
		            if (arrivalA[i].getAtime() <= currentTime) {
		                Heap.add(arrivalA[i]); // Add sheep to the heap
		                for (int j = i; j < arrivalC - 1; j++)
		                {
		                    arrivalA[j] = arrivalA[j + 1];
		                }
		                arrivalA[arrivalC - 1] = null; // Clear last element
		                arrivalC--; 
		                i--; 
		            }
		        }

		        // Shear the next sheep
		        if (!Heap.isEmpty()) {
		            Sheep nextSheep = Heap.remove();
		            System.out.println(nextSheep);
		            currentTime += nextSheep.getStime(); 
		        } else {
		            currentTime = getNextaTime();
		        }
		    }
		}
		private static int getNextaTime() {
		    int nextArrival = Integer.MAX_VALUE;

		    for (int i = 0; i < arrivalC; i++) {
		        if (arrivalA[i] != null && arrivalA[i].getAtime() < nextArrival) {
		            nextArrival = arrivalA[i].getAtime();
		        }
		    }
		    return nextArrival;
		}
	}
