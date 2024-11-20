/*
 * Written by Tamia Simpkins
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Random;

public class RobotCommandSimulator {
	public static final String DELIM = " ";//Setting my DELIM to \n
	public static String[] boardRow;
	public static String[] board;
	public static int columCount = 0;
	public static int numChar = 0;
	public static char[][] charArray = new char[10][10];
	public static int robotX = 0;
	public static int robotY = 0;
	public static int number = 0;
	public static final char ROBOT = 'O';
    GenericQueue<String> moveQueue = new GenericQueue<>();
	
    public void readBoardFile(String file) {
        try {
            Scanner fileScanner = new Scanner(new FileInputStream(file));
            
            columCount = 0;
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                columCount++;
            }
            board = new String[columCount];
            fileScanner.close();
            
            fileScanner = new Scanner(new FileInputStream(file)); // Reopen the scanner
            
            for (int i = 0; i < board.length; i++) {
                if (fileScanner.hasNextLine()) {
                    board[i] = fileScanner.nextLine();
                } else {
                    throw new NoSuchElementException("Not enough lines in the file");//Had to add otherwise I got this error running it the second time
                }
            }
           
            fileScanner.close();

            // Populate charArray from board
            for (int i = 0; i < charArray.length; i++) {
                String temp = board[i];
                for (int j = 0; j < temp.length(); j++) {
                    if (j < charArray[i].length) {
                        charArray[i][j] = temp.charAt(j);
                    }
                }
            }
            
            // Set the robot's initial position
            charArray[robotX][robotY] = ROBOT;

        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("No such element: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

	public void printBoard() {
		for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++)
            {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println();
        }
	}

	public void readRobotFile(String file){
		try {
			Scanner fileScanner = new Scanner(new FileInputStream(file));//Method to scan my file
			while(fileScanner.hasNextLine())//While the file has a next line
			{
				String move = fileScanner.nextLine();
				if (move.equals("Move Up") || move.equals("Move Down") ||
	                    move.equals("Move Left") || move.equals("Move Right")) 
				{
	                    moveQueue.enqueue(move);
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
	    public void simulateCommands() {
            printBoard();
	        while (!moveQueue.isEmpty()) {
	            String command = moveQueue.dequeue();
	            System.out.println("Command: " + number++);
	            boolean moved = false;
	            switch (command) {
	                case "Move Up":
	                    moved = moveRobot(-1, 0);
	                    break;
	                case "Move Down":
	                    moved = moveRobot(1, 0);
	                    break;
	                case "Move Left":
	                    moved = moveRobot(0, -1);
	                    break;
	                case "Move Right":
	                    moved = moveRobot(0, 1);
	                    break;
	                default:
	                    System.out.println("Invalid command");
	                    continue; 
	            }
	            if (!moved) {
	                System.out.println("CRASH!");
	                return; 
	            }
	            printBoard();
	        }
	    }
	    private boolean moveRobot(int changeX, int changeY) {
	    	
	        int newX = robotX + changeX;
	        int newY = robotY + changeY;

	        if (newX < 0 || newX >= charArray.length || newY < 0 || newY >= charArray[0].length) {
	            return false;
	        }

	        // Check for obstacle
	        if (charArray[newX][newY] == 'X') {
	            return false;
	        }

	        // Move  robot
	        charArray[robotX][robotY] = '_'; // Clear old position
	        robotX = newX;
	        robotY = newY;
	        charArray[robotX][robotY] = ROBOT; 
	        return true; 
	    }
	    public void reset() {
	        board = null; 
	        columCount = 0;
	        charArray = new char[10][10]; 
	        robotX = 0; 
	        robotY = 0;
	        number = 0; 
	        moveQueue.clear();
	        
	        charArray[robotX][robotY] = ROBOT;
		}
}

