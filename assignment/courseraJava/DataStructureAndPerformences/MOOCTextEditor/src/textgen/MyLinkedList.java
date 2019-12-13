package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0 ;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next  = tail;
		tail.prev = head;
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		if(element == null)
		{
			throw new NullPointerException();
		}

		LLNode<E> llNode = new LLNode(element);
		llNode.prev = tail.prev;
		llNode.next = tail;
		tail.prev.next = llNode;
		tail.prev = llNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> LLiter = getPrev(index);

		return LLiter.next.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException,NullPointerException
	{
		if(element == null)
		{
			throw new NullPointerException();
		}

		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		

		LLNode<E>llNode = new LLNode(element);
		LLNode<E>LLiter = getPrev(index);

		llNode.next = LLiter.next;
		LLiter.next.prev = llNode;
		LLiter.next = llNode;
		llNode.prev = LLiter;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if(index<0 || index >=size)
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> LLiter = getPrev(index);
		
		E data = LLiter.next.data;
		LLiter.next = LLiter.next.next;
		LLiter.next.prev = LLiter;
		size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException
	{
		if(element == null)
		{
			throw new NullPointerException();
		}
		
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> llNode = getPrev(index);
		LLNode<E> PrevNode = llNode.next;
		llNode.next.data = element;
		
		return PrevNode.data;
	}   

	private LLNode<E> getPrev(int index)
	{
		LLNode<E> llNode = head;

		while(index>0)
		{
			llNode = llNode.next;
			index--;
		}

		return llNode;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
