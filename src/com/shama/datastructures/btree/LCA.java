package com.shama.datastructures.btree;

// lowest common ancestor in binaryTree(BT) and BST
public class LCA {

    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorBT(root.left, p, q);
        TreeNode right = lowestCommonAncestorBT(root.right, p, q);

        //result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else { //both left and right are not null, we found our result
            return root;
        }
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        int curr = root.val;
        if(curr < p.val && curr < q.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        }
        if(curr > p.val && curr > q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }
        return root;
    }
}
