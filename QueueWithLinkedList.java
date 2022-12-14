package com.brian.portfolio.datastructures;

public class QueueWithLinkedList {
    private Node first;
    private Node last;
    private int count;

    public void enqueue(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var value = first.value;
        var second = first.next;

        if (first == last)
            first = last = null;

        else {
            first.next = null;
            first = second;
        }
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return first.value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }


    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
