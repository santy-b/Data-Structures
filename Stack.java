package com.brian.portfolio.datastructures;

import java.util.Arrays;

public class Stack {

    private int size;
    private int count;
    private int[] items;


    public Stack(int size) {
        this.size = size;
        this.items = new int[size];
    }

    public void push(int item) {
        resizeArray();
        items[count++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        var item = items[--count];
        items[count] = 0;
        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[count - 1];
    }
    
    public int min() {
        if (isEmpty())
            throw new IllegalStateException();
        var range = Arrays.copyOfRange(items, 0, count);
        int min = range[0];
        for (int item : range) {
            if (item < min)
                min = item;
        }
        return min;
    }

    private void resizeArray() {
        if (size == count) {
            size = size * 2;
            int[] newItems = new int[size];
            for (int x = 0; x <= count - 1; x++) {
                newItems[x] = items[x];
            }
            items = newItems;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var range = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(range);
    }
}
