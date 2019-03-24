package com.example.queue;

public interface Queue<T> extends Iterable<T>
{
	boolean isEmpty();

	int size();

	T dequeue() throws IllegalStateException;

	boolean enqueue(T data) throws IllegalStateException;
	
	T peek() throws IllegalStateException;
	
	boolean contains(T data);
	
	void clear();
	
	String toString();
}
