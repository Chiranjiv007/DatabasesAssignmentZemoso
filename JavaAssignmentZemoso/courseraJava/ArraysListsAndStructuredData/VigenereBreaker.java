package chiranjiv.courseraJava.ArraysListsAndStructuredData;


public class VigenereBreaker
{
    public String sliceString(String message, int whichSlice, int totalSlices)
    {
        String slicedString = "";
        for(int i= whichSlice;i<message.length();i = i+totalSlices)
        {         
            slicedString = slicedString + message.charAt(i);
        }

        return slicedString;
    }
    
}