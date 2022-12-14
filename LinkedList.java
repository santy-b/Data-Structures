package com.brian.portfolio.datastructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first; //head
    private Node last; //tail
    private int count;



    public void addFirst(int value) {
        count++;
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        count--;
        if (first == last) {
            first = last = null;
            return;
        }
            var second = first.next;
            first.next = null;
            first = second;
    }

    public void addLast(int value) {
        count++;
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        count--;
        if (first == last) {
            first = last = null;
            return;
        }
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
    }



    public int indexOf(int value) {
        byte index = 0;
        while (first != null) {
            if (first.value == value) return index;
            index++;
            first = first.next;
        }
        return -1;
    }

    public int size() {
        return count;
    }

    public boolean contains (int value) {
        while (first != null) {
            if (first.value == value) return true;
            first = first.next;
        }
        return false;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b.next == null)
                throw new IllegalArgumentException();
        }
            while (b != last) {
                a = a.next;
                b = b.next;
        }
        return a.value;
    }

    public boolean hasLoop() {
        var a = first;
        var b = first;

        if (isEmpty())
            throw new IllegalStateException();

        while (b != null) {
            a = a.next;
            b = b.next.next;
            if (b == null)
                return false;
        }
        return true;
    }

    public void printMiddle() {
        var a = first;
        var b = first;

        if (isEmpty())
            throw new IllegalStateException();

        while (b != last && b.next != last ) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last)
            System.out.println(a.value);
        else
        System.out.println(a.value + " & " + a.next.value);
    }

    public int[] toArray() {
        int index = 0;
        int[] array = new int[count];
        if (isEmpty())
            throw new NoSuchElementException();
        while (!isEmpty()) {
            array[index++] = first.value;
            first = first.next;
        }
        return array;
    }

    private boolean isEmpty() {
        return (first == null);
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private class Node {

        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
    }
}
