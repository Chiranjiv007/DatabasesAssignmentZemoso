package Assignment6;

import Assignment6.Fan;

public class TestFan
{
    public static void main(String[] args) throws Exception
    {
        Fan f1 = new Fan(true);
        System.out.println("First constructor Speed: " + f1.speed + " Switch: " + f1.Switch);

        Fan f2 = new Fan(2, true);
        System.out.println("Second constructor Speed: " + f2.speed + " Switch: " + f2.Switch);

        Fan f3 = new Fan(10, true);
        if(f3.speed>5 || f3.speed <0)
        {
            System.out.println("Second Contructor with out of bound Limit Speed: " + f3.speed + " Switch: " + f3.Switch);
            throw new Exception();
        }

    }
}