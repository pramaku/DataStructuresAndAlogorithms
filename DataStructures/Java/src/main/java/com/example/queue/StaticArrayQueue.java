package com.example.queue;

import java.util.Iterator;

/**
 * we cannot create array of generic types in Java, 
 * hence this limitation to Integer.
 *
 */
public class StaticArrayQueue implements Queue<Integer>
{
	private static final int DEFAULT_SIZE = 16;

	private final int size;

	private final Integer[] array;
	
	private int head;
	
	private int tail;

	public StaticArrayQueue()
	{
		this(DEFAULT_SIZE);
	}

	private StaticArrayQueue(int size)
	{
		this.size = size;
		array = new Integer[size];
		head = -1;
		tail = -1;
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext()
			{
				return head <= tail;
			}

			@Override
			public Integer next()
			{
				Integer data = array[head];
				head++;
				return data;
			}
			
		};
	}

	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	@Override
	public int size()
	{
		return tail + 1;
	}

	@Override
	public Integer dequeue() throws IllegalStateException
	{
		Integer data = null;
		if (isEmpty())
		{
			throw new IllegalStateException("queue empty");
		}
		else
		{
			// get the front element
			data = array[head];
			array[head] =  null;
			
			if (head == tail)
			{
				// only one element
				--head;
				--tail;
			}
			else
			{
				// re-adjust the array.
				moveArrayByOne();
				--tail;
			}
		}
		return data;
	}

	private void moveArrayByOne()
	{
		for (int i=head+1; i<=tail; i++)
		{
			array[i-1] = array[i];
		}
	}

	@Override
	public boolean enqueue(Integer data) throws IllegalStateException
	{
		if (isEmpty())
		{
			if ((head + 1) < size)
			{
				++head;
				array[head] = data;
			}
			else
			{
				throw new IllegalStateException("queue full");
			}
			tail = head;
		}
		else
		{
			if ((tail + 1) < size)
			{
				++tail;
				array[tail] = data;
			}
			else
			{
				throw new IllegalStateException("queue full");
			}
		}

		return true;
	}

	@Override
	public Integer peek() throws IllegalStateException
	{
		Integer data = null;
		if (isEmpty())
		{
			throw new IllegalStateException("queue empty");
		}
		else
		{
			// get the front element
			data = array[head];
		}
		return data;
	}

	@Override
	public boolean contains(Integer data)
	{
		boolean found = false;
		if (isEmpty())
		{
			return false;
		}
		else
		{
			for (int i = head; i<=tail; i++)
			{
				if (array[i].equals(data))
				{
					found = true;
					break;
				}
			}
		}
		return found;
	}

	@Override
	public void clear()
	{
		head = tail = -1;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Integer i: this)
		{
			sb.append(i + " -> ");
		}
		
		return sb.toString();
	}
}
