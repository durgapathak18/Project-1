package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains methods to manage files
 * 
 * @author Durga Pathak
 *
 */
public class FileManager 
{
	/**
	 * This method returns the list of names of files in given folder.
	 * 
	 * @param folderLocation
	 * @return List of File Names
	 */
	public static List<String> getNamesOfAllFiles(final String folderLocation) 
	{
		// Create File Object
		File file = new File(folderLocation);
		
		// Gets all files into an array
		File[] listOfFiles = file.listFiles();
		
		// Collect the name of each file in the given folder location
		List<String> fileNames = Arrays.asList(listOfFiles).stream().map(lof -> lof.getName()).collect(Collectors.toList());
		
		// Sort files in alphabetical order
		fileNames.stream().sorted();
		return fileNames;
		
	}
	
	/**
	 * This method writes the contents to a given file name in specified folder location.
	 * 
	 * @param folderLocation
	 * @param fileName
	 * @param contentList
	 * @return boolean (if file saved successfully or not)
	 */
	public static boolean writeContentToFile(final String folderLocation, final String fileName, final List<String> contentList) {
		
		try 
		{
			// Create File Object
			File file = new File(folderLocation, fileName);
			FileWriter fileWriter = new FileWriter(file);
			
			// Loop through each file content and write it to the file
			for (String content : contentList) {
				fileWriter.write(content + "\n");
				
			};
			
			// Close file writer
			fileWriter.close();
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}
		
	}
	
	/**
	 * This method deletes the given file from the given folder.
	 * 
	 * @param folderLocation
	 * @param fileName
	 * @return boolean 
	 */
	public static boolean deleteFile(final String folderLocation, final String fileName) 
	{
		// File to delete
		File file = new File(folderLocation + "\\" + fileName);
		
		try 
		{
			// Delete file
			if (file.delete()) 
			{
				return true;
			}
		} catch (Exception e) 
		{
			return false;
		}
		return false;
		
	}
	
	/**
	 * This method searches files in given folder and informs the user if file exists or not.
	 * 
	 * @param folderLocation
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(final String folderLocation, final String fileName) {
		
		// Create file object with given folder location and file name
		File file = new File(folderLocation + "\\" + fileName);
		
		// Return if file exists or not
		return file.exists();
		
	}

}
