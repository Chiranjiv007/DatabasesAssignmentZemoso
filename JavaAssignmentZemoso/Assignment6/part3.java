/* 

@author: Chiranjiv Goyal

Part 3:- Create a class with a constructor that takes a String argument. 
During construction, print the argument. Create an array of object references to this class, 
but don’t actually create objects to assign into the array. When you run the program, 
notice whether the initialization messages from the constructor calls are printed.

Part 4:- Complete the previous exercise by creating objects to attach to the array of references.

*/
package Assignment6;

public class part3 
{
    String str;

    public static void main(String[] args) throws Exception 
    {
        try
        {
            part3[] part3Array = new part3[10];
        
            for (int i = 0; i < 10; i++) 
            {
                part3Array[i] = new part3("string");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public part3(String string) 
    {
        str = string;
        System.out.println(string);
    }
}
// Part3
// Answer: Nope It Doesnt get printed

// Part4:
// It Prints this this time
