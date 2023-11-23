package org.subasadhikari;

import org.subasadhikari.Queue.Queue;

class Main{
    public static void main(String[] args) throws Exception {
        Queue <Integer>q = new Queue<>(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.peek());


    }
}