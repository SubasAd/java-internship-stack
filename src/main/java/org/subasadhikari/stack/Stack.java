package org.subasadhikari.stack;
import org.subasadhikari.Queue.QueueIsEmptyException;
import org.subasadhikari.Queue.QueueIsFullException;

import java.lang.Object;
import java.util.Arrays;
public class Stack<T> {
    private final int size;
    private T[] stackarray;
    private int curpos ;

    /**
     *
     * @return maximum allowed length
     */
    public int getSize() {
        return size;
    }

    public int getLength() {
        return curpos;
    }

    /**
     *
     * @param size maximum length of the stack.
     */
    public Stack(int size) {
        this.size = size;
        stackarray = (T[])new Object[this.size];
        this.curpos = 0;

    }

    /**
     *
     * @param item
     * @return true if item has been pushed else throws Exception
     */
    public boolean push(T item) throws StackIsFullException {
        if(curpos >= size ){
            throw new StackIsFullException("Stack is Full");

        }else{
            stackarray[curpos++] = item;
            return true;
        }


    }

    /**
     *
     * @return the item that has been popped
     * @throws Exception
     */
    public T pop() throws Exception {
        if (curpos==0){
            throw new StackIsEmptyException("The Stack is Empty");
        }
        T item  = stackarray[curpos-1];
        stackarray[--curpos] = null;

        return item;
    }
    public String toString()
    {
        return Arrays.toString(stackarray);
    }
    public T peek() throws Exception {
        if(curpos == 0)
        {
            throw new StackIsEmptyException("Empty Stack can't be peeked");

        }
        return stackarray[curpos-1];
    }
    public boolean isEmpty()
    {
        return curpos <= 0;
    }
    public boolean isFull() {return curpos==this.size;}
}
