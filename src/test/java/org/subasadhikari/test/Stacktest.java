package org.subasadhikari.test;


import org.subasadhikari.stack.Stack;
import org.junit.Test;
import org.subasadhikari.stack.StackIsEmptyException;
import org.subasadhikari.stack.StackIsFullException;

import static org.junit.Assert.*;

public class Stacktest {

    @Test
    public void testPush() throws StackIsFullException {
        Stack<Integer> stack = new Stack<>(5);

        assertTrue(stack.push(1));
        assertTrue(stack.push(2));
        assertTrue(stack.push(3));
        assertTrue(stack.push(4));
        assertTrue(stack.push(5));


    }

    @Test
    public void testPop() throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        ;
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (long) stack.pop());
        assertEquals(2, (long) stack.pop());
        assertEquals(1, (long) stack.pop());

    }

    @Test
    public void testPopAgainstEmptyStackException()
    {
        Stack<Integer> stack = new Stack<>(5);
        StackIsEmptyException exception = assertThrows(StackIsEmptyException.class, stack::pop);
        assertEquals("The Stack is Empty", exception.getMessage());
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
    public void testPeekAgainstException(){
        Stack<Integer> stack = new Stack<>(5);

        StackIsEmptyException exception = assertThrows(StackIsEmptyException.class, stack::peek);
        assertEquals("Empty Stack can't be peeked", exception.getMessage());
    }

    @Test
    public void testIsEmpty() throws StackIsFullException {
        Stack<Integer> stack = new Stack<>(5);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFullAgainstException() throws StackIsFullException {
        Stack<Integer> stack = new Stack<>(5);
        assertFalse(stack.isFull());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        StackIsFullException sf= assertThrows(StackIsFullException.class,()->stack.push(10));
        assertEquals("Stack is Full",sf.getMessage());

    }
    @Test
    public void testIsFull() throws StackIsFullException {
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