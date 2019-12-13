/*
@author: Chiranjiv Goyal

Create three new types of exceptions. Write a class with a method that throws all three. 
In main( ), call the method but only use a single catch clause that will catch all three types of exceptions. 
Add a finally clause and verify that finally clause is executed, even if a NullPointerException is thrown.

*/


package Assignment8;

class FirstException extends Exception 
{

    public FirstException(String msg) 
    {
        super(msg);
    }
}

class SecondeException extends Exception 
{

    public SecondeException(String msg) 
    {
        super(msg);
    }
}

class ThirdException extends Exception 
{

    public ThirdException(String msg) {
        super(msg);
    }
}

public class MultipleException 
{
    public void throwException(String str) throws FirstException, SecondeException, ThirdException 
    {
        try 
        {
            if (str.equals("First")) 
            {
                throw new FirstException("First");
            } 
            else if (str.equals("Seconde")) 
            {
                throw new SecondeException("Seconde");
            } 
            else if (str.equals("Third")) 
            {
                throw new ThirdException("Third");
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}
