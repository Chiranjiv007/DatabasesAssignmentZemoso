package app;
import java.lang.StringBuilder;

public class CaesarCipher
{
    // Encrypt String using Caeser Cipher code
    public String encrypt(String phrase, int key)
    {
        // Convert String to StringBuilder 
        StringBuilder MyString = new StringBuilder(phrase);

        // loop through every character in given string 
        for (int i=0;i<MyString.length();i++)
        {
            char ch = MyString.charAt(i);

            // Encrypt a alphabetic char to the given key
            MyString.setCharAt(i,CipherChar(ch,key));
        }

        return MyString.toString();
    }

    private char CipherChar(char ch,int key)
    {

        char newChar = ch;

        // Encryption: Shifting the char according to key
        if(ch-'a'>=0 && ch-'z'<26)
        {
            int newLocation = ((ch-'a')+key)%26;
            newChar = (char)('a'+newLocation);
        }
        else if(ch-'A'>=0 && ch-'Z'<26)
        {
            int newLocation = ((ch-'A')+key)%26;
            newChar = (char)('A'+newLocation);

        }
        return newChar;

    }


    public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder MyString = new StringBuilder(input);
        
        for(int i = 0;i<MyString.length();i++)
        {
            char ch = MyString.charAt(i);
            
            // Check index for odd places and even places then call 
            // CipherChar() accordingly
            if(i%2 == 0)
            {
                // Odd places 
                MyString.setCharAt(i,CipherChar(ch, key1));
            }
            else
            {
                // Even places
                MyString.setCharAt(i, CipherChar(ch, key2));
            }
        }

        return MyString.toString();
    }
}