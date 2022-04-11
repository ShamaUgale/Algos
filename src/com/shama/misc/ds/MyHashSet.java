package com.shama.misc.ds;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class MyHashSet {
    Node head;

    public MyHashSet() {
        head = null;
    }

    public void add(int key) {
        if (head == null) {
            head = new Node(key);
            return;
        }
        boolean isExist = contains(key);
        if (!isExist) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(key);
        }
    }

    public void remove(int key) {
        if (head == null) return;
        if (head.val == key) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.val == key) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (head == null) return false;
        if (head.val == key) return true;
        Node current = head;
        while (current.next != null) {
            if (current.next.val == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
