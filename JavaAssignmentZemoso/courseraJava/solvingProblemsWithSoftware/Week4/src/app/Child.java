package app;

import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Child
{

    public void getBirths(FileResource fr)
    {
        int totalBoys = 0;
        int totalGirls = 0;
        int totalBirths = 0;
        CSVParser parser = fr.getCSVParser(false);

        for(CSVRecord record : parser)
        {
            int numBorn = Integer.parseInt(record.get(2));
            String gender = record.get(1);
            totalBirths += numBorn;
            if(gender.equals("M"))
            {
                totalBoys+=numBorn;
            }
            else
            {
                totalGirls+=numBorn;
            }
        }

        
        System.out.println("Total Births: " + totalBirths);
        System.out.println("Total Boys: " + totalBoys );
        System.out.println("Total Girls: " + totalGirls);
    }



    public long getRank(int year, String name , String gender)
    {
        long rank = -1;
		FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
		CSVParser parser = fr.getCSVParser(false);

		for(CSVRecord record : parser) {
			String currName = record.get(0);
			String currGender = record.get(1);
			
			if(currGender.equals(gender) && currName.equals(name)) {
				rank = record.getRecordNumber();
			}
		}
		return rank;

    }


    public String getName(int year , int rank, String gender)
    {
        String name = "";
		FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
		CSVParser parser = fr.getCSVParser(false);

		for(CSVRecord record : parser) {
			long currRank = record.getRecordNumber();
			String currGender = record.get(1);
			String currName = record.get(0);

			if(currRank == rank && currGender.equals(gender)) {
				name = currName;
			}
		}

		if(name != "") {
			return name;
		} 
		else {
			return "NO NAME";
		}
    }


    public void whatIsNameInYear(String name, int year, String gender, int newYear)
    {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
		FileResource newFr = new FileResource("us_babynames/us_babynames_test/yob" + newYear + "short.csv");
		CSVParser parserOld = fr.getCSVParser(false);
		CSVParser parserNew = newFr.getCSVParser(false);
		String newName = "";
		long popularity = 0;

		for(CSVRecord record : parserOld) {
			String currName = record.get(0);
			String currGender = record.get(1);

			if(currName.equals(name) && currGender.equals(gender)) {
				popularity = record.getRecordNumber();
			}
		}

		for(CSVRecord record : parserNew) {
			String currGender = record.get(1);
			long currPopularity = record.getRecordNumber();

			if(currGender.equals(gender) && popularity == currPopularity) {
				newName = record.get(0);
			}
		}

		System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);

    }


    public int yearOfHighestRank(String name, String gender)
    {
        long highestRank = 0;
		int yearOfHighestRank = -1;
		String fileName = "";
		DirectoryResource dr = new DirectoryResource();
		
		// Iterate through all files
		for(File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			
			// Iterate through all records in file
			for(CSVRecord record : parser) {
				String currName = record.get(0);
				String currGender = record.get(1);

				if(currName.equals(name) && currGender.equals(gender)) {
					long currRank = record.getRecordNumber();
					
					if(highestRank == 0) {
						highestRank = currRank;
						fileName = f.getName();
					} 
					else {
						if(highestRank > currRank) {
							highestRank = currRank;
							fileName = f.getName();
						}
					}
				}
			}
		}

		// Remove all non-numeric characters from the filename
		fileName = fileName.replaceAll("[^\\d]", "");
		
		// Convert String fileName to Integer
		yearOfHighestRank = Integer.parseInt(fileName);

		return yearOfHighestRank;
    }

    public double getAverageRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
		// Define rankTotal, howMany
		double rankTotal = 0.0;
		int howMany = 0;
		// For every file the directory add name rank to agvRank
		for(File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			for(CSVRecord record : parser) {
				String currName = record.get(0);
				String currGender = record.get(1);
				if(currName.equals(name) && currGender.equals(gender)){
					long currRank = record.getRecordNumber();
					rankTotal += (double)currRank;
					howMany += 1;
				}
			}
		}
		// Define avgRank = rankTotal / howMany
		double avgRank = rankTotal / (double)howMany;
		return avgRank;
    }

    public int getTotalBirthsRankedHigher(String name, String gender, int year)
    {
        int numBorn = 0;
		long rank = getRank(year, name, gender);
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord record : parser) {
			int currBorn = Integer.parseInt(record.get(2));
			String currGender = record.get(1);
			long currRank = record.getRecordNumber();
			if(gender.equals(currGender) && rank > currRank) {
				numBorn += currBorn;
			}
		}
		return numBorn;
    }

    public void testTotalBirths()
    {
        FileResource fr = new FileResource("yob1900.csv");
        getBirths(fr);

        String name = getName(2012, 7, "M");
		System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.testTotalBirths();
    }
}