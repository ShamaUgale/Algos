package com.shama.datastructures.btree;

public class FloorBst {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int val)
        {
            data=val;
            left=null;
            right=null;
        }
    }

    public static int floorInBST(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }

            if (key > root.data) {
                floor = root.data;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return floor;
    }
}