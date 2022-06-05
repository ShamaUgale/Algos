package com.shama.datastructures.graphs.dfs;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node){
        if(node == null){
            return node;
        }

        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> map){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }else{
            Node copy = new Node(node.val);
            map.put(node.val, copy);
            for(Node ngh : node.neighbors){
                copy.neighbors.add(cloneGraph(ngh, map));
            }
            return copy;
        }
    }
}
