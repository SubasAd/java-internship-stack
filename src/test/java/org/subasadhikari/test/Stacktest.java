package org.subasadhikari.test;


import org.subasadhikari.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class Stacktest {

    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>(5);
        Exception exception = assertThrows(Exception.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));
        assertFalse(stack.push(6)); // Stack is full, should return false

    }

    @Test
    public void testPop() throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        Exception exception = assertThrows(Exception.class, stack::peek);
        assertEquals("The Stack is empty", exception.getMessage());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (long) stack.pop());
        assertEquals(2, (long) stack.pop());
        assertEquals(1, (long) stack.pop());

    }

    @Test
    public void testPeek() throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (long) stack.peek());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<>(5);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        Stack<Integer> stack = new Stack<>(5);
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertTrue(stack.isFull());
    }
    @Test
    public void testGenericStack() throws Exception {
        Stack<String> stringStack = new Stack<>(3);
        assertTrue(stringStack.push("One"));
        assertTrue(stringStack.push("Two"));
        assertFalse(stringStack.isEmpty());
        assertEquals("Two", stringStack.pop());
    }
}