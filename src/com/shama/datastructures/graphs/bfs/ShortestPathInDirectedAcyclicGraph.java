package com.shama.datastructures.graphs.bfs;

import java.util.*;

class Pair {
    private int v;
    private int weight;

    Pair(int _v, int _w) {
        this.v = _v;
        this.weight = _w;
    }

    int getV() {
        return this.v;
    }

    int getWeight() {
        return this.weight;
    }
}

// using BFS and toposort
/*
The reason of using topo sort is simple,
we save a lot of time by starting from the start point,
instead of starting from any random point. Since we know via topo sort
we get to know the starting point, hence it becomes optimal to use topo sort!

 */
class ShortestPathInDirectedAcyclicGraph {
    void topologicalSortUtil(int node, boolean visited[], Stack stack, ArrayList<ArrayList<Pair>> adj) {

        visited[node] = true;
        for(Pair it: adj.get(node)) {
            if(visited[it.getV()] == false) {
                topologicalSortUtil(it.getV(), visited, stack, adj);
            }
        }
        stack.add(node);
    }

    void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N) {
        Stack stack = new Stack();
        int distance[] = new int[N];

        boolean visited[] = new boolean[N];
        for (int i = 0; i < N; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack, adj);

        for (int i = 0; i < N; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[s] = 0;

        while (stack.empty() == false) {
            int node = (int)stack.pop();

            if (distance[node] != Integer.MAX_VALUE) {
                for(Pair neighbour: adj.get(node)) {
                    if(distance[node] + neighbour.getWeight() < distance[neighbour.getV()]) {
                        distance[neighbour.getV()] = distance[node] + neighbour.getWeight();
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( distance[i] + " ");
        }
    }
    public static void main(String args[]) {
        int n = 6;
        ArrayList<ArrayList<Pair> > adj = new ArrayList<ArrayList<Pair> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Pair>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));
        ShortestPathInDirectedAcyclicGraph obj = new ShortestPathInDirectedAcyclicGraph();
        obj.shortestPath(0, adj, n);

    }
}