package com.brian.portfolio.datastructures;

import java.util.Arrays;

public class DualStack {
    private int size;
    private int count1;
    private int count2;
    private int[] items;


    public DualStack(int size) {
        this.size = size;
        this.count2 = size - 1;
        this.items = new int[size];
    }

    public void push1(int item) {
        if (isFull())
            throw new StackOverflowError();
        items[count1++] = item;
    }

    public void push2(int item) {
        if (count1 - 1 == count2)
            throw new StackOverflowError();
        items[count2--] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();
        var item = items[count1--];
        items[count1] = 0;
        return item;
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();
        var item = items[count2++];
        items[count2] = 0;
        return item;
    }

    public boolean isEmpty1() {
        return count1 == 0;
    }

    public boolean isEmpty2() {
        return count2 == size - 1;
    }

    public boolean isFull() {
        return count1 - 1 == count2;
    }

    @Override
    public String toString() {
        var range1 = Arrays.copyOfRange(items, 0, count1);
        var range2 = Arrays.copyOfRange(items, count2 + 1, size);
        return Arrays.toString(range1) + " " + Arrays.toString(range2);
    }
}
