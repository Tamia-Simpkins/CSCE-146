/*
 * Written by Tamia Simpkins
 */

import java.util.Scanner;

public class RobotCommandSimulatorFE {
	
	private static RobotCommandSimulator RobotCommand = new RobotCommandSimulator();

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
				while(!quit) {
					RobotCommand.reset();
					
					System.out.println("Welcome to the Robot Simulator");
					System.out.println("Enter file for the Board");
					
					String FILE_NAME = keyboard.nextLine();
					RobotCommand.readBoardFile(FILE_NAME);//Calling readBoardFile and passing String FILLE_NAME through it
					
					System.out.println("Enter file for the Robot Commands");
					
					String ROBO_NAME = keyboard.nextLine();
					RobotCommand.readRobotFile(ROBO_NAME);
					
					RobotCommand.simulateCommands();
						
					System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
					
					String answer = keyboard.nextLine();
						if(answer.equalsIgnoreCase("true")){
							quit = true;
						}
						if(answer.equals("")) {
							FILE_NAME = null;
							ROBO_NAME = null;
							quit = false;
						}
							}
	}

}
