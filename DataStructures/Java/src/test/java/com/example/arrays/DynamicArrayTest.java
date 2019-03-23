package com.example.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DynamicArrayTest
{
	@Test
	public void testConstructor()
	{
		DynamicArray<Integer> arr = new DynamicArray<>();
		assertEquals(0, arr.size());
	}
	
	@Test
	public void testConstructorWithGivenCapacity()
	{
		DynamicArray<Integer> arr = new DynamicArray<>(24);
		assertEquals(0, arr.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithInvalidCapacity()
	{
		new DynamicArray<>(-2);
	}
}
