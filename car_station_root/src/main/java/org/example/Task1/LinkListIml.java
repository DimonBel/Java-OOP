package org.example.Task1;
import java.util.LinkedList;

public class LinkListIml<T> implements Queue_Impl<T>{

    LinkedList<T> states = new LinkedList<T>();


    @Override
    public void enqueue(T X) {
        states.add(X);
    }

    @Override
    public void dequeue() {
        if (states.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        System.out.println(states.removeFirst());  // Remove and return the first element
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }

    public int size() {
        return states.size();
    }
}
