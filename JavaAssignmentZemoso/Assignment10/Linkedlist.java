/*
@author:- Chiranjiv Goyal

Create a generic, singly linked list class called SList, which, does not implement the List interface.
    
Each Link object in the list should contain a reference to the next element in the list, 
but not the previous one (LinkedList, in contrast, is a doubly linked list, 
which means it maintains links in both directions).

Create your own SListIterator which, does not implement ListIterator. 
The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

The only way to insert and remove elements from an SList is through SListIterator.

*/

package Assignment10;

import java.util.*;

class Slist 
{
    private LinkedListObject headlink = new LinkedListObject(null);

    SlistIterator iterator() 
    {
        return new SlistIterator(headlink);
    }

    public String toString() 
    {
        if (headlink.next == null) 
        {
            return "SList: []";
        }

        SlistIterator it = this.iterator();
        StringBuilder s = new StringBuilder("[ ");
        
        while (it.hasNext()) 
        {
            s.append(it.next() + (it.hasNext() ? " " : ""));
        }

        return s + " ]";
    }

}

class SlistIterator 
{
    LinkedListObject current;

    SlistIterator(LinkedListObject link) 
    {
        current = link;
    }

    public LinkedListObject next() 
    {
        current = current.next;
        return current;
    }

    public boolean hasNext() 
    {
        return current.next != null;
    }

    public void insert(String str) 
    {
        LinkedListObject obj = new LinkedListObject(str);
        current.next = obj;
        current = current.next;
    }

    public void remove() 
    {
        if (current.next != null) 
        {
            current.next = current.next.next;
        }
    }

}

class LinkedListObject 
{
    String s;
    LinkedListObject next;

    LinkedListObject(String str) 
    {
        this.s = str;
        this.next = null;
    }

    public String toString() 
    {
        if (s == null) 
        {
            return "null";
        }
        return s.toString();
    }
}

public class Linkedlist 
{
    public static void main(String[] args) 
    {
        Slist sl = new Slist();
        System.out.println(sl);
        SlistIterator it = sl.iterator();
        it.insert("hi");
        System.out.println(sl);
        it.insert("Sweetie");
        it.insert("!! Whats up??");
        System.out.println(sl);

        SlistIterator it2 = sl.iterator();
        it2.remove();
        System.out.println(sl);
    }
}
