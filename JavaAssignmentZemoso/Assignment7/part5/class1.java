/*
@author:- Chrianjiv Goyal

Create a class with an inner class that has a non-default constructor (one that takes arguments). 
Create a second class with an inner class that inherits from the first inner class.
*/

package Assignment7.part5;


public class class1 
{
    int func;

    class class2 
    {
        int var1;
        int var2;

        class2(int v1, int v2) 
        {
            var1 = v1;
            var2 = v2;
        }

    }
}

class secondClass
{
    class inheritedclass extends class2
    {
        public void method1()
        {
            System.out.println("Class2 method1");
        }

    }
    
}
