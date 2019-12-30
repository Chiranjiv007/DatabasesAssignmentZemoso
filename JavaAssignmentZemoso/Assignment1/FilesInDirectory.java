/*
@author:- Chiranjiv Goyal

Create a java program to search through the home directory and 
look for files that match a regular expression. 
The program should be able to take inputs repeatedly and 
should print out the full absolute path of the matching files found.


*/
package Assignment1;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;

public class FilesInDirectory
{
	/**
	 * Print all files matching to regex in the home directory with there path
	 * @throws IOException
	 */

	public void matchFilesInDirectory() throws IOException
	{
		/**
			Call user for pattern to be given as input. Inserting 'N' will exit the program.
		*/
		String pattern = "";
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		
		while(pattern != "N")
		{
			System.out.println("ENTER THE PATTERN(Enter 'N' to Quit): ");
			pattern = reader.readLine();
			if(pattern.equals("N"))
			{
				System.exit(0);
			}
			
			// Call for function to look for files that match regular expression.
			File[] files = new File(".").listFiles();
			try
			{
				matchFiles(files,"", pattern);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}


	/**
		@return void
		@param (File[], String, String): array of files/folders in directory, path of the directory, pattern to match
		Prints all the files in the directory that matches the pattern
	*/
	private void matchFiles(File[] files,String path, String pattern) throws Exception
	{
		String DirectoryName = path;

		for (File file : files)
		{
			String fileName = file.getName();

			// If the file is directory then recursively call the function
			// with suitable parameters
			if(file.isDirectory())
			{
				DirectoryName = path+"/" + fileName;
				matchFiles(file.listFiles(), DirectoryName, pattern);
				DirectoryName = path;
			}
			else
			{
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(fileName);
				boolean b = m.matches();
				if(b)
				{
					System.out.println("Path: " + DirectoryName + "/" + fileName);
				}
			}
		}
	}
}