package com.shama.datastructures.btree;

import java.util.*;

public class TopView {

        static class Pair {
            int vertical;
            Node node;
            Pair(Node n, int v) {
                node = n;
                vertical = v;
            }
        }
        static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.remove();
                int vertical = curr.vertical;
                Node node = curr.node;
                if (!map.containsKey(vertical))
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
