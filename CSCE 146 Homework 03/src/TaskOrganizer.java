/*
 * Written by Tamia Simpkins
 */
import java.io.*;
import java.util.Scanner;
public class TaskOrganizer {
	public static Scanner keyboard = new Scanner(System.in);
	private static TaskOrganizerManager aTask = new TaskOrganizerManager();//Creating a new instanace of TaskOrganizerManager named aTask
	private static TaskOrganizer bTask = new TaskOrganizer();
	public static GenLL<Task> currentResults = new GenLL<Task>();//Creating a new instance of GENLL with the input Task named currentResults
	private GenLL<Task>[] organizedTasks;
	public static final String DELIM = "\t";//Setting my DELIM to \t
	public static final int FIELD_AMT=2;
	
	public static void main(String[] args) {
		boolean quit = false;//While loop to loop the code.
		System.out.println("Welcome to the Task Organizer!");
		TaskOrganizer organizer = new TaskOrganizer();
		while(!quit)//Runs until the user quits
		{
			System.out.println("Enter 1. To Add a Task"
                    + "\nEnter 2. To Remove a Task"
                    + "\nEnter 3. To Print Tasks to console"
                    + "\nEnter 4. To Read from a Task File"
                    + "\nEnter 5. To Write to a Task File"
                    + "\nEnter 9. To quit");
			int pick = keyboard.nextInt();
			switch(pick)
			{
			case 1: 
				System.out.print("Enter the task's priority (0-4): ");
                int Priority = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline
                System.out.print("Enter the task's action: ");
                String Action = keyboard.nextLine();
                organizer.addTask(Action, Priority);
                break;
			case 2:
				 System.out.print("Enter the task's priority (0-4): ");
                 Priority = keyboard.nextInt();
                 keyboard.nextLine(); // Consume newline
                 System.out.print("Enter the task's action: ");
                 Action = keyboard.nextLine();
                 organizer.removeTask(Action, Priority);
                 break;
			case 3:
			    organizer.print(currentResults); // Call the print method from the TaskOrganizer instance
			    break;

			case 4:
				System.out.println("Enter the file name: ");
				String file = keyboard.next();
				aTask.ReadFile(file, currentResults);
                break;
			case 5:
				printDatatoFile(currentResults);
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

	public TaskOrganizer() {
		organizedTasks = new GenLL[5];
		for(int i = 0; i<organizedTasks.length;i++) {
			organizedTasks[i] = new GenLL<>();
		}
	}
	public void addTask(String action, int priority) {
	    Task newTask = new Task(action, priority);
	    organizedTasks[priority].add(newTask);
	    currentResults.add(newTask); // Add to currentResults too
	}
	public void removeTask(String action, int priority) {
        Task taskToRemove = new Task(action, priority);
        organizedTasks[priority].remove(taskToRemove);
        currentResults.remove(taskToRemove); // Remove to currentResults too
    }
	public static void printDatatoFile(GenLL<Task> currentResults) {
	    System.out.println("Enter the file name: ");
	    keyboard.nextLine(); 
	    String fileName = keyboard.nextLine();
	    System.out.println("Append to file? True or false.");
	    String append = keyboard.nextLine();
	    if (append.equalsIgnoreCase("true")) {
	        bTask.writeToFile(fileName, true, currentResults);//Method to write a file.
	    } else if (append.equalsIgnoreCase("false")) {
	        bTask.writeToFile(fileName, false, currentResults);
	    } else {
	        System.out.println("Invalid Input");
	    }
	}
	public void print(GenLL<Task> results) {
	    if (results.getSize() == 0) {
	        System.out.println("No tasks available.");
	        return;
	    }
	    for (int i = 0; i < organizedTasks.length; i++) {
	        organizedTasks[i] = new GenLL<Task>();
	    }
	    results.reset();//Rest the results
	    while (results.hasMore()) {//Sorting based on priority
	        Task currentTask = results.getCurrent();
	        int priority = currentTask.getPriority(); // Assuming Task has a getPriority method
	        if (priority >= 0 && priority < organizedTasks.length) {
	            organizedTasks[priority].add(currentTask);
	        }
	        results.goToNext();
	    }
	    for (int i = 0; i < organizedTasks.length; i++) {
	        if (!organizedTasks[i].isEmpty()) {
	            organizedTasks[i].reset(); // Reset to iterate through the list
	            while (organizedTasks[i].hasMore()) {
	                Task task = organizedTasks[i].getCurrent();
	                System.out.println("  " + task);
	                organizedTasks[i].goToNext();
	            }
	        }
	    }
	}
	public void writeToFile(String fileName, boolean append, GenLL<Task> results) {
	    try (PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append))) {
	        for (int i = 0; i < organizedTasks.length; i++) {
	            organizedTasks[i].reset(); // Ensure each GenLL is empty
	        }
	        results.reset();
	        while (results.hasMore()) {
	            Task currentTask = results.getCurrent();
	            int priority = currentTask.getPriority();
	            if (priority >= 0 && priority < organizedTasks.length) {
	                organizedTasks[priority].add(currentTask);
	            }
	            results.goToNext();
	        }
	        for (int i = 0; i < organizedTasks.length; i++) {
	            if (!organizedTasks[i].isEmpty()) {
	                organizedTasks[i].reset(); // Reset to iterate through the list
	                while (organizedTasks[i].hasMore()) {
	                    Task task = organizedTasks[i].getCurrent();
	                    fileWriter.println(task.getAction() + DELIM + task.getPriority());
	                    organizedTasks[i].goToNext();
	                }
	            }
	        }
	        
	    } 
	    catch (IOException e) {
	        System.out.println("Error writing to file: " + e.getMessage());
	    }
	}
}
	