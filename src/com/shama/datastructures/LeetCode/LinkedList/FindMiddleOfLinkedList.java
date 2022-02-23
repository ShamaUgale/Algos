package com.shama.datastructures.LeetCode.LinkedList;

public class FindMiddleOfLinkedList {

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

    private Node findMiddle(Node head){
        if(head == null){
            return null;
        }
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
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
        FindMiddleOfLinkedList list = new FindMiddleOfLinkedList();
        list.insertNodeLast(6);
        list.insertNodeLast(34);
        list.insertNodeLast(3);
        list.insertNodeLast(56);
//        list.insertNodeLast(90);


        list.printNodes(list.head);
        Node middleNode = list.findMiddle(list.head);
        System.out.println("The middle of list is : " + middleNode.data);
    }
}
