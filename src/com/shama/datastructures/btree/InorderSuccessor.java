package com.shama.datastructures.btree;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
