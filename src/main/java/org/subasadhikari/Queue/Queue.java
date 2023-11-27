package org.subasadhikari.Queue;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Queue<T> {
        private  int size;
        private T[] queue;
        private int curposFront ;
        private int curposBack ;
        private int length;

        public int getSize() {
            return size;
        }

        public int getLength() {

            return this.length;
        }

        public Queue(int size) {
            this.size = size;
            queue = (T[])new Object[this.size];
            this.curposFront = 0;
            this.curposBack = 0;
            this.length = 0;

        }

    /**
     *
     * @param item
     * @return true if item is added throws Exception if Queue is full.
     */
    public boolean enqueue(T item) throws QueueIsFullException {
            if(this.isFull() ){
                throw new QueueIsFullException("Queue is Full");
            }else{
                queue[(curposFront)%this.size] = item;
                curposFront++;
                this.length++;
                return true;
            }


        }

    /**
     *
     * @return item that has been dequeued
     * @throws Exception if queue is empty
     */
    public T dequeue() throws Exception {
            if (this.isEmpty()){
                throw new QueueIsEmptyException("Queue is Empty");
            }
            T item  = queue[curposBack%this.size];
            queue[(curposBack++)%this.size] = null;
            this.length--;

            return item;
        }

    /**
     *
     * @return array representation of the queue
     */
    public String toString()
        {
            return Arrays.toString(queue);
        }
        public T peek() throws Exception {
            if(this.isEmpty())
            {
                throw new QueueIsEmptyException("The Queue is empty");

            }
            return queue[(curposFront-1)%this.size];
        }
        public boolean isEmpty()
        {
            return length == 0;
        }
        public boolean isFull() {return length == this.size;}

    }


