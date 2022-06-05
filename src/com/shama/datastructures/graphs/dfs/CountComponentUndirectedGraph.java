package com.shama.datastructures.graphs.dfs;

import java.util.ArrayList;

public class CountComponentUndirectedGraph {
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, vis, adj);
            }
        }
    }

    public static int dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int noOfConnectedComponents = 0;
        boolean vis[] = new boolean[V+1];

        for(int i = 1;i<=V;i++) {
            if(!vis[i]) {
                noOfConnectedComponents++;
                dfs(i, vis, adj);
            }
        }
        return noOfConnectedComponents;
    }

    public static void main(String args[]) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(5).add(1);

        int ans = dfsOfGraph(5, adj);
        System.out.println(ans);
    }
}
