package com.example.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StaticArrayQueueTest
{
	private static final int DEFAULT_SIZE = 16;
	
	@Test
	public void testConstructor()
	{
		StaticArrayQueue queue = new StaticArrayQueue();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testEnqueue()
	{
		StaticArrayQueue queue = new StaticArrayQueue();
		queue.enqueue(10);
		assertEquals(1, queue.size());
		
		queue.enqueue(20);
		assertEquals(2, queue.size());
		
		queue.enqueue(30);
		assertEquals(3, queue.size());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testEnqueueWithFull()
	{
		StaticArrayQueue queue = new StaticArrayQueue();
		int size = DEFAULT_SIZE + 5;
		for (int i=0; i<size; i++)
		{
			queue.enqueue((i + 1) * 10);
		}
	}
	
	@Test
	public void testDequeue()
	{
		StaticArrayQueue queue = new StaticArrayQueue();
		queue.enqueue(10);
		assertEquals(new Integer(10), queue.dequeue());
		assertTrue(queue.isEmpty());
		
		
		queue = new StaticArrayQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(2, queue.size());
		assertEquals(new Integer(10), queue.dequeue());
		assertEquals(1, queue.size());
		assertEquals(new Integer(20), queue.dequeue());
		assertTrue(queue.isEmpty());
		
		
		queue = new StaticArrayQueue();
		queue.enqueue(10);
		assertEquals(1, queue.size());
		assertEquals(new Integer(10), queue.dequeue());
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		
		queue.enqueue(20);
		assertEquals(new Integer(20), queue.dequeue());
		assertTrue(queue.isEmpty());
		
	}
	
	@Test
	public void testIterator()
	{
		StaticArrayQueue queue = new StaticArrayQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		
		//Iterator<Integer> it = queue.iterator();
		for(Integer i: queue)
		{
			System.out.println(i);
		}
	}
	
	@Test
	public void testToString()
	{
		StaticArrayQueue queue = new StaticArrayQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		
		System.out.println(queue);
	}
}
