package com.shama.datastructures.btree;

public class Max_height_depth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }
}
