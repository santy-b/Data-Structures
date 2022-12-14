package com.brian.portfolio.datastructures;

public class PriorityQueue {
    private int count;
    private int[] items;
    public PriorityQueue(int length) {
        this.items = new int[length];
    }

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length - 1;
    }
}
