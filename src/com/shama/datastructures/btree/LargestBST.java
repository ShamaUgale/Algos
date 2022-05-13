package com.shama.datastructures.btree;

public class bstpair {
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

    public static bstpair isBST(Node node) {

        if (node == null) {
            bstpair bp = new bstpair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = null;
            bp.size = 0;
            return bp;
        }

        bstpair lp = isBST(node.left);
        bstpair rp = isBST(node.right);

        bstpair mp = new bstpair();

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
