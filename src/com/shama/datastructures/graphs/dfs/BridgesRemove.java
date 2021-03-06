package com.shama.datastructures.graphs.dfs;

import java.util.*;

class BridgesRemove {

    private void dfs(int node, int parent, boolean vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer) {
        vis[node] = true;
        tin[node] = low[node] = timer++;

        for(Integer neighbour: adj.get(node)) {
            if(neighbour == parent) {
                continue;
            }

            if(!vis[neighbour]) {
                dfs(neighbour, node, vis, tin, low, adj, timer);
                low[node] = Math.min(low[node], low[neighbour]);

                if(low[neighbour] > tin[node]) {
                    System.out.println(neighbour + " " +node);
                }
            } else {
                low[node] = Math.min(low[node], tin[neighbour]);
            }
        }
    }
    void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean vis[] = new boolean[n];
        int tin[] = new int[n];
        int low[] = new int[n];

        int timer = 0;
        for(int i = 0;i<n;i++) {
            if( !vis[i]) {
                dfs(i, -1, vis, tin, low, adj, timer);
            }
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        BridgesRemove obj = new BridgesRemove();
        obj.printBridges(adj, n);

    }
}