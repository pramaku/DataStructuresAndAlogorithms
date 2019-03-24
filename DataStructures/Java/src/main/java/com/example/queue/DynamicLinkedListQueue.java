package com.example.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class DynamicLinkedListQueue<T> implements Queue<T>
{
	private LinkedList<T> list = new LinkedList<>();

	@Override
	public Iterator<T> iterator()
	{
		return list.iterator();
	}

	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	@Override
	public int size()
	{
		return list.size();
	}

	@Override
	public T dequeue() throws IllegalStateException
	{
		T data = list.poll();
		if (data == null)
		{
			throw new IllegalStateException();
		}
		
		return data;
	}

	@Override
	public boolean enqueue(T data) throws IllegalStateException
	{
		return list.offerLast(data);
	}

	@Override
	public T peek() throws IllegalStateException
	{
		T data = list.peekFirst();
		
		if (data == null)
		{
			throw new IllegalStateException();
		}
		
		return data;
	}

	@Override
	public boolean contains(T data)
	{
		return list.contains(data);
	}

	@Override
	public void clear()
	{
		list.clear();
	}

}
