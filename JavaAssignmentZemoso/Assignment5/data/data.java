/*
    Author: Chiranjiv Goyal
    Last Update: 5 july 2019


    Print Fields and Local vairables which are not intialized
*/

package Assignment5.data;

public class data
 
{

    int variable1;
    char variable2;

    public void PrintVar() throws Exception
    {
        try
        {
            System.out.println("Integer Variable: " + variable1);
            System.out.println("Char Variable: " + variable2);
        }
        catch(Exception err)
        {
            System.out.println(err.getMessage());
            System.exit(1);
        }

    }

    // Cannot Perform this action
    /*
     * public void PrintVarLocal() { int variable3; char variable4;
     * System.out.println("Local Integer Variable: " + variable3);
     * System.out.println("Local Char Variable: " + variable4);
     * 
     * }
     */
}
