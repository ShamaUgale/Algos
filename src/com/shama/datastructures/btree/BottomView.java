package com.shama.datastructures.btree;
import java.util.*;


/*
Tip: Here there is only 1 small difference from the Top View of the Tree.
Here we don’t need to check whether the node is previously present on the map or node before entering it.
We have to replace the node of each line if that was previously present on the map.
 */
public class BottomView {
    static class Pair {
        int vertical;
        Node node;
        Pair(Node n, int v) {
            node = n;
            vertical = v;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.remove();
                int vertical = curr.vertical;
                Node node = curr.node;
                map.put(vertical, node.val);
                if (node.left != null)
                    q.add(new Pair(node.left, vertical - 1));
                if (node.right != null)
                    q.add(new Pair(node.right, vertical + 1));
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            res.add(entry.getValue());
        return res;
    }
}
