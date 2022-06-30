package com.shama.datastructures.btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindDuplicateSubTree {

    Map<String, Integer> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap();
        result = new ArrayList();
        traverse(root);
        return result;

    }

    private String traverse(TreeNode node){
        if(node == null){
            return "$";
        }

        String subPath = node.val + "," + traverse(node.left) + "," + traverse(node.right);
        map.put(subPath, map.getOrDefault(subPath, 0)+1);

        if(map.get(subPath) == 2){
            result.add(node);
        }

        return subPath;
    }
}
