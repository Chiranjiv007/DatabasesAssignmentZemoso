/*
    Author: Chiranjiv Goyal
    Last Update: 5 july 2019

    Create class in package yourname.assignment.singleton 
    containing a non static String member variable. Add a static method 
    that takes String as parameter and initialize the member variable 
    and then return object of that class. Add a non static method to print the String.
*/
package Assignment5.singleton;

public class singleton 
{
    String variable1;

    public static void main(String[] args) 
    {
    }

    public static singleton IntializeMember(String str) 
    {
        singleton returnObject = new singleton();
        
        // variable1 = str Cannot perform this
        returnObject.variable1 = str;
        return returnObject;
    }

    public void PrintVar() 
    {
        System.out.println("String Variable: " + variable1);
    }

}
