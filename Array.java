package com.brian.portfolio.datastructures;

public class Array {
    private byte count;
    private int[] items;

    public Array(int length) {
        this.items = new int[length];
        count = 0;
    }

    public void insert(int item) {
        items[count++] = item;

        if (count == items.length) {
            int[] newItems = new int[items.length * 2];
            for (int x = 0; x <= items.length - 1; x++)
                newItems[x] = items[x];
            items = newItems;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public int max() {
        int largest = 0;
        for (int item : items)
            if (item > largest)
                largest = item;
        return largest;
    }

    public int[] intersect (int[] list) {
        int x = 0;
        var common = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            for (int y = 0; y <= count - 1; y++)
                if (items[i] == list[y]) {
                    common[x++] = items[i];
                    break;
                }
        }
        return common;
    }

    public int[] reverse () {
        var reverse = new int[count];
        for (int i = count - 1, y = 0; i >= 0; i--, y++)
            reverse[y] = items[i];
        return reverse;
    }

    public void insertAt(int item, int index) {
        if (items[index] == 0)
            count++;
        for (int i = 0; i <= items.length - 1; i++)
            if (i == index)
                items[i] = item;
    }

    public void print() {
        for (int i = 0; i <= count -1; i++)
            System.out.println(items[i]);
    }
}
