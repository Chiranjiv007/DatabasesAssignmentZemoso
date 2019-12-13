/*
@author:- Chiranjiv Goyal

Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. 
Create factories for each type of Cycle, and code that uses these factories.
*/


package Assignment7.part4;

interface Cycle 
{
    void ride();
}

interface CycleFactory 
{
    Cycle getCycle();
}

class Unicycle implements Cycle 
{
    public void ride() 
    {
        System.out.println("Riding Unicycle");
    }
}

class UnicycleFactory implements CycleFactory 
{
    public Cycle getCycle() 
    {
        return new Unicycle();
    }
}

class Bicycle implements Cycle 
{
    public void ride() 
    {
        System.out.println("Riding Bicycle");
    }
}

class BicycleFactory implements CycleFactory 
{
    public Cycle getCycle() 
    {
        return new Bicycle();
    }
}

class Tricycle implements Cycle 
{
    public void ride() 
    {
        System.out.println("Riding Tricycle");
    }
}

class TricycleFactory implements CycleFactory 
{
    public Cycle getCycle() 
    {
        return new Tricycle();
    }
}

public class Main 
{
    public static void ridingCycle(CycleFactory factory) throws Exception
    {   
        try
        {
            Cycle cyc = factory.getCycle();
            cyc.ride();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) 
    {
        ridingCycle(new UnicycleFactory());
        ridingCycle(new BicycleFactory());
        ridingCycle(new TricycleFactory());

    }
}
