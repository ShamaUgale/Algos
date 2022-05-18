package com.shama.datastructures.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
 */
public class TreeView {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

         TreeNode(int val) {
             this.val = val;
         }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
              this.right = right;
          }
      }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int ind = 0; ind < levelSize; ind++) {
                TreeNode node = queue.poll();
                if (ind == levelSize - 1)
                    rightView.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return rightView;
    }

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int ind = 0; ind < levelSize; ind++) {
                TreeNode node = queue.poll();
                if (ind == levelSize - 1)
                    leftView.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return leftView;
    }

        public List<Integer> rightSideViewRecursive(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            rightView(root, result, 0);
            return result;
        }

        public void rightView(TreeNode curr, List<Integer> result, int currDepth){
            if(curr == null){
                return;
            }
            if(currDepth == result.size()){
                result.add(curr.val);
            }

            rightView(curr.right, result, currDepth + 1);
            rightView(curr.left, result, currDepth + 1);

        }
    }

