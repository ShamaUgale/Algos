package com.shama.datastructures;

public class ReverseLinkedList {

    private Node head;

    private static class Node {
        private Node next;
        private int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void printNodes(Node head){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
    }

    private Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private void insertNodeLast(int value){
        Node newNode = new Node(value);
        if(null == head){
            head = newNode;
            return;
        }
        Node current = head;
        while(null != current.next){
            current = current.next;
        }
        current.next= newNode;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insertNodeLast(6);
        list.insertNodeLast(34);
        list.insertNodeLast(3);
        list.insertNodeLast(56);

        list.printNodes(list.head);

        Node reveredNode = list.reverse(list.head);
        System.out.println("After reversing");
        list.printNodes(reveredNode);

    }
}
