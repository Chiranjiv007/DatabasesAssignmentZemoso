/*
    Author: Chiranjiv Goyal
    Last Update: 5 july 2019

    Create class in package yourname.assignment.singleton 
    containing a non static String member variable. Add a static method 
    that takes String as parameter and initialize the member variable 
    and then return object of that class. Add a non static method to print the String.
*/
package Assignment5.singleton;

public class Singleton 
{
    /* 
        Create a String memeber variable as mentioned in problem
        and an object of singleton
    */
    String SingletonField;
    private static Singleton instance = new Singleton();
    
    // make the constructor private so that this class cannot be instantiated
    private Singleton(){}

    // Get the object available 
    public static Singleton getInstance(String str) 
    {
        instance.SingletonField = str;
        return instance;
    }

    // Prints the String field of the object available
    public void printSingletonField() 
    {
        System.out.println("String Variable: " + instance.SingletonField);
    }

}
