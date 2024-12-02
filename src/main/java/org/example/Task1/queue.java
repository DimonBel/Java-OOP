package org.example.Task1;

import java.util.*;

public class queue<T> implements Queue_Impl<T>{
    public static Object enqueue;

    // front and rear variables are initially initiated to
    // -1 pointing to no element that control queue
    int front = -1, rear = -1;

    ArrayList<T> A = new ArrayList<>();

    public T front() {
        // If it is not pointing to any element in queue
        if (front == -1)

            return null;

        // else return the front element
        return A.get(front);
    }


    public T rear() {
        // If it is not pointing to any element in queue
        if (rear == -1)
            return null;
        return A.get(rear);
    }


    @Override
    public void enqueue(T X) {
        // If queue is empty
        if (this.empty()) {
            front = 0;
            rear = 0;
            A.add(X);
        }

        // If queue is not empty
        else {
            front++;
            if (A.size() > front) {

                // Mov front pointer to next
                A.set(front, X);
            } else

                // Add element to the queue
                A.add(X);
        }
    }

    @Override
    public void dequeue() {
// if queue doesn't have any elements
        if (this.empty())

            // Display message when queue is already empty
            System.out.println("Queue is already empty");

            // If queue has only one element
        else if (front == rear) {

            // Both are pointing to same element
            front = rear = -1;
        }

        // If queue has more than one element
        else {

            // Increment the rear
            rear++;
        }
    }


    public boolean empty() {
        // Both are initialized to same value
        // as assigned at declaration means no queue made
        if (front == -1 && rear == -1)
            return true;
        return false;
    }



    public String toString() {
        if (this.empty())
            return "";

        String Ans = "";

        for (int i = rear; i < front; i++) {
            Ans += String.valueOf(A.get(i)) + "->";
        }

        Ans += String.valueOf(A.get(front));

        return Ans;
    }
}
