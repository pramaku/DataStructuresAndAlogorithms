package com.example.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable<T>
{
	private int size = 0;
	private Node<T> top = null;
	
	@SuppressWarnings("hiding")
	private class Node<T>
	{
		T data = null;
		Node<T> next = null;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void push(T data)
	{
		if (isEmpty())
		{
			top = new Node<T>();
			top.data = data;
		}
		else
		{
			Node<T> trav = top;
			top = new Node<T>();
			top.next = trav;
			top.data = data;
		}
		++size;
	}

	public T pop()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}

		T data = top.data;
		top = top.next;
		--size;
		return data;
	}

	public boolean find(T data, boolean searchNull)
	{
		boolean found = false;
		
		if (isEmpty())
		{
			throw new RuntimeException("Stack is empty");
		}
		
		Node<T> trav = top;
		while (trav != null)
		{
			if (searchNull && data == null)
			{
				found = true;
				break;
			}
			else if(trav.data.equals(data))
			{
				found = true;
				break;
			}
			else
			{
				trav = trav.next;
			}
		}
		return found;
	}

	public T peek()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return top.data;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			Node<T> trav = top;

			@Override
			public boolean hasNext()
			{
				return trav != null;
			}

			@Override
			public T next()
			{
				T data = trav.data;
				trav = trav.next;
				return data;
			}
		};
	}

}
