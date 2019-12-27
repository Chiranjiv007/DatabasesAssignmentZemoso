/*
@author: Chiranjiv Goyal

A java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive). 
Write time and space complexity of your solution as comments in the source file.

Time Complexity: O(n)
Space Complexity:- O(n)
n:- Length of String

*/
package Assignment2;

public class CheckAllAlphabet
{
    /**
     * Checks if a string contains all the alphabets or not
     * @param str
     * @return boolean
     */
    public boolean checkAlphabets(String str)
    {

        int[] MyIntArray = new int[26];
        
        for (int i = 0; i < str.length(); i++) 
        {
            char c = str.charAt(i);
            
            if (c - 'a' >= 0 && c - 'a' < 26) 
            {
                MyIntArray[c - 'a']++;              
            }
            else if (c - 'A' >= 0 && c-'A' < 26)
            {
                MyIntArray[c - 'A']++;

            }
        }

        for (int i = 0; i <= 25; i++) 
        {
            if (MyIntArray[i] == 0) 
            {
                return false;
            }
        }
        return true;
    }

}