package com.example.lists;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T>
{
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;

	@SuppressWarnings("hiding")
	private class Node<T>
	{
		T data = null;
		Node<T> next = null;
		Node<T> prev = null;
		
		public Node(T data, Node<T> next, Node<T> prev)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString()
		{
			return data.toString();
		}
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T> () {
			Node<T> trav = null;
			@Override
			public boolean hasNext()
			{
				return trav.next != null;
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

	public void clear()
	{
		Node<T> trav = head;
		while (trav != null)
		{
			Node <T> next = trav.next;
			trav.data = null;
			trav.prev = null;
			trav.next = null;
			trav = next;
		}

		head = tail = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void add(T elem)
	{
		addLast(elem);
	}
	
	public void addFirst(T elem)
	{
		if (isEmpty())
		{
			// first element
			Node<T> node = new Node<T>(elem, null,  null);
			head = node;
			tail = node;
		}
		else
		{
			Node<T> node = new Node<T>(elem, null,  head);
			head.prev = node;
			head = node;
		}
		size++;
	}

	public void addLast(T elem)
	{
		if (isEmpty())
		{
			// first element
			Node<T> node = new Node<T>(elem, null,  null);
			head = node;
			tail = node;
		}
		else
		{
			// add to the last.
			Node<T> node = new Node<T>(elem, tail,  null);
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public T peekFirst()
	{
		if (isEmpty())
		{
			throw new RuntimeException("List is empty");
		}
		return head.data;
	}
	
	public T peekLast()
	{
		if (isEmpty())
		{
			throw new RuntimeException("List is empty");
		}
		return tail.data;
	}
	
	public T removeFirst()
	{
		if (isEmpty())
		{
			throw new RuntimeException("List is empty");
		}

		T data = head.data;
		head = head.next;

		--size;
		if (isEmpty())
		{
			// check if we removed last element,
			tail = null;
		}
		else
		{
			head.prev = null; // prev of first node always null.
		}

		return data;
	}
	
	public T removeLast()
	{
		if (isEmpty())
		{
			throw new RuntimeException("List is empty");
		}
		
		// if only one element, (head and tail are same)
		if (size == 1)
		{
			T data = head.data;
			head = tail = null;
			--size;
			return data;
		}
		else
		{
			T data = tail.data;
			tail = tail.prev;
			tail.next = null;
			--size;
			return data;
		}
	}
	
	public T removeAt(int index)
	{
		if (isEmpty())
		{
			throw new RuntimeException("List is empty");
		}

		if (index >= size || index < 0)
		{
			throw new IllegalArgumentException("index is not proper");
		}
		
		Node<T> trav = null;
		if (index < size/2)
		{
			trav = head;
			int count = 0;
			while (trav != null)
			{
				if (index != count)
				{
					count++;
					trav = trav.next;
				}
				else
				{
					break;
				}
			}
		}
		else
		{
			trav = tail;
			int count = size - 1;
			while (trav != null)
			{
				if (index != count)
				{
					count++;
					trav = trav.prev;
				}
				else
				{
					break;
				}
			}
		}
		
		// now trav is at the index node
		return remove(trav);
	}

	public boolean remove(T data)
	{
		Node<T> trav = head;
		boolean found = false;
		if (data == null)
		{
			// support searching null values.(returns the first occurrence of null)
			while (trav != null)
			{
				if (trav.data == null)
				{
					remove(trav);
					found = true;
					break;
				}
				else
				{
					trav = trav.next;
				}
			}
		}
		else
		{
			while (trav != null)
			{
				if (trav.data.equals(data))
				{
					remove(trav);
					found = true;
					break;
				}
				else
				{
					trav = trav.next;
				}
			}
		}
		
		return found;
	}

	public int indexOf(T data)
	{
		int index = -1;
		Node<T> trav = head;
		if (data == null)
		{
			// support searching null values.(returns the first occurrence of null)
			while (trav != null)
			{
				if (trav.data == null)
				{
					break;
				}
				else
				{
					trav = trav.next;
				}
				index++;
			}
		}
		else
		{
			while (trav != null)
			{
				if (trav.data.equals(data))
				{
					break;
				}
				else
				{
					trav = trav.next;
				}
				index++;
			}
		}
		return index;
	}

	public boolean contains(T data)
	{
		return indexOf(data) != -1;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node<T> trav = head;
		while (trav != null)
		{
			sb.append(trav.toString());
			if (trav.next != null)
			{
				sb.append(" ,");
			}
		}
		sb.append(" ]");
		return sb.toString();
	}

	private T remove(Node<T> node)
	{
		if (node.next == null)
		{
			return removeLast();
		}
		
		if (node.prev == null)
		{
			return removeFirst();
		}
		
		node.next.prev = node.prev;
		node.prev.next = node.next;
		
		T data = node.data;
		--size;
		return data;
	}
}
