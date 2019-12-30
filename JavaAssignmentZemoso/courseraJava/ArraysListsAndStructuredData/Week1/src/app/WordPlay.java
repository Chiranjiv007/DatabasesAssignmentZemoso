package app;

import java.lang.Character;
import java.lang.StringBuilder;

public class WordPlay
{
    public boolean isVowel(char ch)
    {
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        {

            return true;
        }
        
        return false;
    }

    public String replaceVowels(String phrase, char ch)
    {
        StringBuilder myString = new StringBuilder(phrase.toLowerCase());

        for(int i=0; i<myString.length();i++)
        {
            if(isVowel(myString.charAt(i)))
            {
                myString.setCharAt(i, ch);
            }
        }

        return myString.toString();
    }

    public String emphasize(String phrase, char ch)
    {
        StringBuilder myString = new StringBuilder(phrase.toLowerCase());

        for(int i=0; i<myString.length();i++)
        {    
            if(myString.charAt(i) == ch)
            {
                if(i%2 == 0)
                {
                    myString.setCharAt(i,'*');                 
                }
                else
                {
                    myString.setCharAt(i, '+');
                }
            }
        }
        return myString.toString();
    }


}