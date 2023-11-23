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
        public boolean enqueue(T item){
            if(this.isFull() ){
                return false;
            }else{
                queue[(curposFront)%this.size] = item;
                curposFront++;
                this.length++;
                return true;
            }


        }
        public T dequeue() throws Exception {
            if (this.isEmpty()){
                throw new Exception("Queue is empty");
            }
            T item  = queue[curposBack%this.size];
            queue[(curposBack++)%this.size] = null;
            this.length--;

            return item;
        }
        public String toString()
        {
            return Arrays.toString(queue);
        }
        public T peek() throws Exception {
            if(this.isEmpty())
            {
                throw new Exception("The Queue is empty");

            }
            return queue[(curposFront-1)%this.size];
        }
        public boolean isEmpty()
        {
            return length == 0;
        }
        public boolean isFull() {return length == this.size;}
        public void printpos(){
            System.out.println(curposFront);
            System.out.println(curposBack);
        }
    }


