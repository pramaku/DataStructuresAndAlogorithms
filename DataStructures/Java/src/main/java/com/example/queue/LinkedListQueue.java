package com.example.queue;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T>
{
	private Node<T> head =null;
	private Node<T> tail =null;
	private int size;

	public LinkedListQueue()
	{
		this(16);
	}

	public LinkedListQueue(int size)
	{
		this.size = size;
	}

	@SuppressWarnings("hiding")
	class Node<T>
	{
		T data;
		Node<T> next;
		
		@Override
		public String toString()
		{
			return data.toString();
		}
	}
	
	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	public boolean isEmpty()
	{
		return size() != 0;
	}
	
	@Override
	public boolean enqueue(T data)
	{
		Node<T> node = new Node<>();
		node.data = data;
		
		if (isEmpty())
		{
			head = tail = node;
		}
		else
		{
			tail.next = node;
			tail = node;
		}
		size++;
		return true;
	}
	
	@Override
	public T dequeue() throws IllegalStateException
	{
		if (isEmpty()) throw new IllegalStateException();
		
		--size;
		T data = head.data;
		head = head.next;
		return data;
	}
	
	@Override
	public T peek() throws IllegalStateException
	{
		if (isEmpty()) throw new IllegalStateException();
		
		return head.data;
	}
	
	@Override
	public boolean contains(T data)
	{
		if (isEmpty())
		{
			System.out.println("Queue is empty");
			return false;
		}
		
		Node<T> trav = head;
		boolean found = false;
		while (trav != null)
		{
			if (trav.data.equals(data))
			{
				found = true;
				break;
			}
			trav = trav.next;
		}
		
		return found;
	}
	
	@Override
	public void clear() throws IllegalStateException
	{
		if (isEmpty()) throw new IllegalStateException();
		
		while (head != null)
		{
			head.data = null;
			head = head.next;
			--size;
		}
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>() {

			Node<T> trav = head;
			@Override
			public boolean hasNext() {
				return trav != null;
			}

			@Override
			public T next() {
				T data = trav.data;
				trav = trav.next;
				return data;
			}
		};
	}

	@Override
	public String toString()
	{
		Iterator<T> it = this.iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext())
		{
			sb.append(it.next() + " -> ");
		}
		
		return sb.toString();
	}
}
