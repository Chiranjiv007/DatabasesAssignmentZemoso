/*

@author: Chiranjiv Goyal

fan class with two (overloaded) constructors. 
fan(boolean swtch) constructor call the second constructor fan(int spd, boolean swtch) inside the if.

*/
package Assignment6;

public class Fan 
{
    int speed;
    boolean Switch;

    public Fan(int spd, boolean swtch) 
    {
        speed = spd;
        Switch = swtch;
    }

    public Fan(boolean swtch) 
    {
        this(0, swtch);
    }
}
