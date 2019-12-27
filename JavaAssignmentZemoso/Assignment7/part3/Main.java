/*
@author: Chiranjiv Goyal

Create three interfaces, each with two methods. Inherit a new interface that combines the three, 
adding a new method. Create a class by implementing the new interface and 
also inheriting from a concrete class. Now write four methods, 
each of which takes one of the four interfaces as an argument. 
In main( ), create an object of your class and pass it to each of the methods.

*/

package Assignment7.part3;

interface interface1 
{
    void u();
    void v();
}

interface interface2 
{
    void w();
    void x();
}

interface interface3 
{
    void y();
    void z();
}

interface mainInterface extends interface3, interface2, interface1 
{
    void zz();
}

class Class1 
{
    private int i = 0;
    public void doc() {}
}

class Class2 extends Class1 implements mainInterface 
{
    private int j = 0;
    public void u() {}
    public void v() {}
    public void w() {}
    public void x() {}
    public void y() {}
    public void z() {}
    public void zz() {}
}

public class Main 
{
    public static void m1(interface1 i1) 
    { 
        i1.v(); 
    }
    
    public static void m2(interface2 i2) 
    { 
        i2.w(); 
    }
    
    public static void m3(interface3 i3) 
    { 
        i3.y(); 
    } 
    
    public static void m4(mainInterface mi) 
    { 
        mi.zz(); 
    }

    public static void main(String[] args) 
    {
        Class2 c2 = new Class2();
        m1(c2);
        m2(c2);
        m3(c2);
        m4(c2);
    }
}