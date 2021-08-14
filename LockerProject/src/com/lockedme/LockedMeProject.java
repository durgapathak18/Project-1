package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject 
{

	static final String folderLocation = "C:\\Users\\15124\\eclipse-workspace\\LockedMeFiles";
	public static void main(String[] args) 
	{
		int proceed = 1;
		int choice;
		// Create scanner object to get input from user
		Scanner scanner = new Scanner(System.in);
		
		do 
		{
			// Display Menu
			displayMenu();
			
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(scanner.nextLine());
			
			switch (choice) {
			case 1: getAllFiles();
					break;
			case 2: createFiles(scanner);
					break;
			case 3: deleteFile(scanner);
					break;
			case 4: searchFile(scanner);
					break;
			case 5: 
					System.out.println("\nThank you for visiting lockedme.com \nVisit us again.");
					System.exit(0);
					break;
			default:
					System.err.println("\nLooks like you picked invalid option. Try again.");
					break;
			}
		} while (proceed > 0);
		
		scanner.close();
	}
	
	private static void displayMenu() 
	{
		System.out.println("\n\n*************************************************************");
		System.out.println("\t\t\tLockedMe.com");
		System.out.println("*************************************************************");
		System.out.println("1. Display all files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*************************************************************");

	}
	
	/**
	 * Gets the name of all files.
	 */
	private static void getAllFiles() 
	{
		// Gets the name of all files in the given folder
		List<String> namesOfAllFiles = FileManager.getNamesOfAllFiles(folderLocation);
		
		// Print file names
		namesOfAllFiles.stream().forEach(name -> System.out.println(name));
	}
	
	/**
	 * This method creates a file
	 */
	private static void createFiles(Scanner scanner) 
	{
		// Variable declarations
		String fileName;
		int totalNumOfLines;
		List<String> listOfContent = new ArrayList<String>();
		
		// Read file name from user
		System.out.println("Enter File Name: ");
		fileName = scanner.nextLine();
		
		// Ask user for how many lines of content they intend to write to a file
		System.out.print("Enter the number of lines in the file: ");
		totalNumOfLines =Integer.parseInt(scanner.nextLine());
		
		// Collect content for each line
		for (int i = 1; i <= totalNumOfLines; i++) 
		{
			System.out.println("Enter content for line " + i);
			listOfContent.add(scanner.nextLine());
			
		}
		
		// Save content to the file
		boolean isContentSaved = FileManager.writeContentToFile(folderLocation, fileName, listOfContent);
		
		if (isContentSaved) 
		{
			System.out.println("\nContent successfully saved to " + fileName);
		}
		else
		{
			System.out.println("Exception occured. Unable to write contents to a file. Contact support@simplilearn.com");
		}
		
	}
	
	/**
	 * Deletes a file in the folder
	 */
	private static void deleteFile(Scanner scanner) 
	{
		// Variable declaration
		String fileName;
		System.out.println("Enter file name to delete: ");
		fileName = scanner.nextLine();
		
		boolean isFileDeleted = FileManager.deleteFile(folderLocation, fileName);
		
		if (isFileDeleted) 
		{
			System.out.println("\n" + fileName + " is deleted successfully.");
		}
		else
		{
			System.out.println("\nUnable to delete specified file. Verify if given file exist and try again.");
		}
		
	}
	
	/**
	 * Searches a file in the folder
	 */
	private static void searchFile(Scanner scanner) {

		// Variable declaration
		String fileName;
		System.out.println("Enter file name to search: ");
		fileName = scanner.nextLine();
		
		boolean isFileDeleted = FileManager.searchFile(folderLocation, fileName);
		
		if (isFileDeleted) 
		{
			System.out.println("\n" + fileName + " exists in the folder");
		}
		else
		{
			System.out.println("\n"  + fileName + "does not exist in specified folder.");
		}
		
	}

}
