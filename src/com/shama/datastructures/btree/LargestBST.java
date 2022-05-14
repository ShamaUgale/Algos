package com.shama.datastructures.btree;

public class LargestBST {
    boolean isBST;

    int min;
    int max;
    Node root;     //1
    int size;

    public static class Node {
        int data;
        Node left;
        Node right;
        Node() {
        }
        Node(int data) {
            this.data = data;
        }
    }


//****************IS BST*****************

    public static LargestBST isBST(Node node) {

        if (node == null) {
            LargestBST bp = new LargestBST();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = null;
            bp.size = 0;
            return bp;
        }

        LargestBST lp = isBST(node.left);
        LargestBST rp = isBST(node.right);

        LargestBST mp = new LargestBST();

        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if (mp.isBST) {         //2
            mp.root = node;
            mp.size = lp.size + rp.size + 1;
        } else if (lp.size > rp.size) {  //3
            mp.root = lp.root;
            mp.size = lp.size;
        } else {  //4
            mp.root = rp.root;
            mp.size = rp.size;
        }

        return mp;
    }
}
