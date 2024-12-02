package org.example.Task1;

public class CircularArray<T> implements Queue_Impl<T> {
    private int[] array;
    private int size;
    private int head;
    private int tail;

    // Constructor
    public CircularArray(int capacity) {
        array = new int[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }


    // Enqueue (Add Element) Method
    @Override
    public void enqueue(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[tail] = (int) element;
        tail = (tail + 1) % array.length;
        size++;
    }


    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Circular array is empty");
        }
        int removedElement = array[head];
        head = (head + 1) % array.length;
        size--;
        System.out.println(removedElement);
    }

    // ResizeArray Method
    private void resizeArray() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }

    // Check if CircularArray is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
