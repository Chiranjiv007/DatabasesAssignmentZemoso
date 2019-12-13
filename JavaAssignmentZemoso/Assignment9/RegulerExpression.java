/*
@author:- Chiranjiv Goyal

Using the documentation for java.util.regex.Pattern as a resource, 
write and test a regular expression that checks a sentence to see that 
it begins with a capital letter and ends with a period.
*/

package Assignment9;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegulerExpression 
{
    public boolean testSentence(String sentence) throws Exception
    {
        String pattern = "";
        boolean matches = false;
        
        try
        {
            pattern = "^[A-Z][^.]*.$";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(sentence);
            matches = m.matches();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }


        if (matches) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
        
    }

}
