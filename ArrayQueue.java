package com.brian.portfolio.datastructures;

import java.util.Arrays;

public class ArrayQueue {
    private int front;
    private int rear;
    private int count;
    private int[] items;

    public ArrayQueue(int length) {
        this.items = new int[length];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        return items[front];
    }

    public boolean isFull() {
        return (count == items.length);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
