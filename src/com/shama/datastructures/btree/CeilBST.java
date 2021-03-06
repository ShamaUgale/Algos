package com.shama.datastructures.btree;

public class CeilBST {
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
    public  static int findCeil(TreeNode root, int key) {

        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (key > root.data) {
                root = root.right;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;

    }
}