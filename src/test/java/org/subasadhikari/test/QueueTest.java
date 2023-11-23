package org.subasadhikari.test;
import org.subasadhikari.Queue.Queue;
import org.junit.Test;

import static org.junit.Assert.*;




    public class QueueTest {

        @Test
        public void testEnqueueDequeue() throws Exception {
            Queue<Integer> queue = new Queue<>(5);

            assertTrue(queue.isEmpty());
            assertFalse(queue.isFull());

            // Enqueue elements
            assertTrue(queue.enqueue(1));
            assertTrue(queue.enqueue(2));
            assertTrue(queue.enqueue(3));

            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());

            // Dequeue elements
            assertEquals(1, (long)queue.dequeue());
            assertEquals(2,(long)queue.dequeue());

            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());

            // Enqueue more elements
            assertTrue(queue.enqueue(4));
            assertTrue(queue.enqueue(5));
            assertTrue(queue.enqueue(6));
            assertTrue(queue.enqueue(7));
            assertFalse(queue.isEmpty());
            assertTrue(queue.isFull());

            // Dequeue the remaining elements
            assertEquals(3, (long)queue.dequeue());
            assertEquals(4,(long) queue.dequeue());
            assertEquals(5,(long) queue.dequeue());
            assertEquals(6,(long)queue.dequeue());
            assertEquals(7,(long)queue.dequeue());

            assertTrue(queue.isEmpty());
            assertFalse(queue.isFull());
        }

        @Test
        public void testPeek() throws Exception {
            Queue<String> queue = new Queue<>(3);

            assertTrue(queue.isEmpty());

            queue.enqueue("One");
            queue.enqueue("Two");
            queue.enqueue("Three");

            assertEquals("Three", queue.peek());
            assertFalse(queue.isEmpty());

            queue.dequeue();
            assertEquals("Three", queue.peek());

            queue.dequeue();
            assertEquals("Three", queue.peek());

            queue.dequeue();
            assertTrue(queue.isEmpty());

            assertThrows(Exception.class, queue::peek);
        }

        @Test
        public void testEmptyQueueDequeue() {
            Queue<Double> queue = new Queue<>(4);

            assertTrue(queue.isEmpty());

            assertThrows(Exception.class, queue::dequeue);
        }

        @Test
        public void testFullQueueEnqueue() {
            Queue<Character> queue = new Queue<>(2);

            assertTrue(queue.isEmpty());

            queue.enqueue('A');
            queue.enqueue('B');

            assertTrue(queue.isFull());

            assertFalse(queue.enqueue('C'));
        }
    }


