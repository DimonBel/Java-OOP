package org.example.Task1;

import org.example.Task1.queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class queueTest {
    //queue<Integer> queue1 = new queue<>();
    @Test
    void enqueue() {
        queue<Integer> queue = new queue<>();
        queue<Integer> queue2 = new queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.rear());
        queue.dequeue();
        assertEquals(2, queue.rear());
        assertTrue(queue2.empty());
    }

    @Test
    void dequeue() {
        queue<Integer> queue1 = new queue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        assertEquals(1, queue1.rear());
        queue1.dequeue();
        assertEquals(2, queue1.rear());
        queue1.dequeue();
        assertNull(queue1.front());
    }
}