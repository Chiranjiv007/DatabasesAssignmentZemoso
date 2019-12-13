package Assignment2;

import Assignment2.CheckAllAlphabet;

public class testCheckAlphabets
{
    /**
     * tester of checkalphabet function int ChackAllAphabets class
     * @param args
     */
    public static void main(String[] args)
    {
        CheckAllAlphabet checkAllAlphabet = new CheckAllAlphabet();
        String s = "AByqwertyuiopasdfghjklzx";

        if (checkAllAlphabet.checkAlphabets(s)) 
        {
            System.out.println("Sahi hai!! Yay");
        } 
        else 
        {
            System.out.println("You are missing Something. You need to improve broooo.");
        }

    }
}