package org.subasadhikari.Queue;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Queue<T> {
        private  int size;
        private T[] queue;
        private int curposFront ;
        private int curposBack ;

        public int getSize() {
            return size;
        }

        public int getLength() {
            return curposFront - curposBack;
        }

        public Queue(int size) {
            this.size = size;
            queue = (T[])new Object[this.size];
            this.curposFront = 0;
            this.curposBack = 0;

        }
        public boolean enqueue(T item){
            if((curposFront +1)%this.size == curposBack%this.size ){
                return false;
            }else{
                queue[(curposFront++)%this.size] = item;
                return true;
            }


        }
        public T dequeue() throws Exception {
            if (curposFront%this.size==curposBack%this.size){
                throw new Exception("Queue is empty");
            }
            T item  = queue[curposBack];
            queue[(curposBack++)%this.size] = null;

            return item;
        }
        public String toString()
        {
            return Arrays.toString(queue);
        }
        public T peek() throws Exception {
            if(curposFront%this.size == curposBack%this.size)
            {
                throw new Exception("The Queue is empty");

            }
            return queue[(curposFront-1)%this.size];
        }
        public boolean isEmpty()
        {
            return curposFront%this.size == curposBack%this.size;
        }
        public boolean isFull() {return abs(curposFront%this.size-curposBack%this.size)==this.size;}
    }


