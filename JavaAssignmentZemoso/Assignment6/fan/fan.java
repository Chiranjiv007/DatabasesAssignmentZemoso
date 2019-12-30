/*

@author: Chiranjiv Goyal

fan class with two (overloaded) constructors. 
fan(boolean swtch) constructor call the second constructor fan(int spd, boolean swtch) inside the if.

*/
package assignment2.fan;

public class fan 
{
    // Create two fields to fan class spee and switch
    int speed;
    boolean Switch;

    public static void main(String[] args) throws Exception
    {
        fan f1 = new fan(true);
        System.out.println("First constructor Speed: " + f1.speed + " Switch: " + f1.Switch);

        fan f2 = new fan(2, true);
        System.out.println("Second constructor Speed: " + f2.speed + " Switch: " + f2.Switch);

        fan f3 = new fan(10, true);
        System.out.println("Second Contructor with out of bound Limit Speed: " + f3.speed + " Switch: " + f3.Switch);

    }


    public fan(int spd, boolean swtch) 
    {
        if (spd > 5 || spd < -1) 
        {
            throw new Exception("Speed out of bounds");
        }
        speed = spd;
        Switch = swtch;

    }

    public fan(boolean swtch) 
    {
        this(0, swtch);
        System.out.println(swtch);
    }
}
