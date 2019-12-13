package Assignment1;

import Assignment1.FilesInDirectory;

public class TestFilesInDirectory
{
    public static void main(String[] args) throws Exception
    {
        FilesInDirectory filesInDirectory = new FilesInDirectory();
        try
        {
            filesInDirectory.matchFilesInDirectory();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}