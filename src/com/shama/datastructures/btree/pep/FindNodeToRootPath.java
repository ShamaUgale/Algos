package com.shama.datastructures.btree.pep;
import java.io.*;

import java.util.*;

public class FindNodeToRootPath {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack< Pair> st = new Stack< >();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        boolean filc = find(node.left, data);
        if (filc) {
            return true;
        }

        boolean firc = find(node.right, data);
        if (firc) {
            return true;
        }

        return false;
    }

    public static ArrayList< Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            return new ArrayList< >();
        }

        if (node.data == data) {
            ArrayList< Integer> list = new ArrayList< >();
            list.add(node.data);
            return list;
        }

        ArrayList< Integer> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node.data);
            return llist;
        }

        ArrayList< Integer> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node.data);
            return rlist;
        }
        return new ArrayList< >();
    }

    public static void main(String[] args) throws Exception {
        Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = construct(arr);
        boolean found = find(root, 70);
        System.out.println(found);

        ArrayList< Integer> path = nodeToRootPath(root, 70);
        System.out.println(path);
    }
}