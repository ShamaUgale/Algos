package com.shama.datastructures.btree;
import java.util.*;

class NodesAtDistanceK {

    // this is O(N)
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    // iterative approach (can be done with recursive as well)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();

        // map of nodes as key and all the parent as vals
        // so if I do a get node from map i know who is the parent for this node
        markParents(root, parent_track);

        // visited so when i am moving in all directions, i dont go to the same direction again
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(target);
        visited.put(target, true);

        // this is k counter, as soon as i reach k distance from nodes i break
        int curr_level = 0;

        // second BFS to go upto K level from target node and using our hashtable info
        // O(N) is worst case
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(curr_level == k)
                break;
            curr_level++;
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }
        return result;
    }
}
