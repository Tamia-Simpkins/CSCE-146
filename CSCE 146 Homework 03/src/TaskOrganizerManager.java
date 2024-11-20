/*
 * Written by Tamia Simpkins
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskOrganizerManager {
	public static final String DELIM = "\t";//Setting my DELIM to \t
	public static final int FIELD_AMT=2;
	private GenLL<Task> Tasks;
	private GenLL<Task> current;//MAYBE DELETE


	public TaskOrganizerManager() {
		Tasks = new GenLL<Task>();//Creating a new instance of GENLL using Task and setting it equal to current
		current = new GenLL<Task>();

	}
	public void ReadFile(String file, GenLL<Task> currentResults) {
	    try (Scanner fileScanner = new Scanner(new FileInputStream(file))) {
	        while (fileScanner.hasNextLine()) {
	            String fileLine = fileScanner.nextLine().trim();
	            String[] splitLines = fileLine.split(DELIM);//Splitting at the DELIM
	            if (splitLines.length == FIELD_AMT) {
	            	try {
	                int Priority = Integer.parseInt(splitLines[0]);//Have to use parseInt to covert from String to the Int
	                String Action = splitLines[1];
	                if(Priority >= 0 && Priority <= 4) {//Important parameters
	                Task newTask = new Task(Action, Priority);
	                Tasks.add(newTask); 
	                currentResults.add(newTask); 
	                
	                }
	                else {
	                	 System.out.println("Invalid priority in line: " + fileLine);
	                }
	            }
	            	catch(Exception e) {
		            	System.out.println(e);
		            }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error reading file: " + e.getMessage());
	    }
	}
}

