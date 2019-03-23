package com.example.arrays;

public class DynamicArray<T>
{
	private T[] arr;
	private int length = 0;

	@SuppressWarnings("unused")
	private int capacity = 0;

	public DynamicArray()
	{
		this(16);
	}

	@SuppressWarnings("unchecked")
	public DynamicArray(int capacity)
	{
		if (capacity < 0)
		{
			throw new IllegalArgumentException("Invalid capacity provided " + capacity);
		}
		
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size()
	{
		return length;
	}
	
	public boolean isEmpty()
	{
		return length == 0;
	}

	public void set(int index, T value)
	{
		arr[index] = value;
	}
	
	public T get(int index)
	{
		return arr[index];
	}
	
	public boolean contains(T element)
	{
		return false;
	}
	
	public int indexOf(T element)
	{
		return -1;
	}
	
	public T removeAt(int index)
	{
		return null;
	}
	
	public boolean remove(T element)
	{
		return false;
	}
	
	public void clear()
	{
		
	}

	public void insert(int index, T element)
	{
		
	}
	
	public void append(T element)
	{
		
	}
	
	public String toString()
	{
		return "[]";
	}
}
