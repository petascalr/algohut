package com.specflare.algohut.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally,
 * for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge
 * in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 */

/**
 * Determining if a graph can be colored with 2 colors is equivalent to determining whether or not the graph is bipartite,
 * and thus computable in linear time using breadth-first search or depth-first search.
 */
// 785. Is Graph Bipartite?
// https://leetcode.com/problems/is-graph-bipartite/
// Status: OK, Solution Accepted.
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int node = 0; node < graph.length; node++) {
            if (colors[node] == 0) {
                q.add(node);
                colors[node] = 1;
                while (!q.isEmpty()) {
                    int currNode = q.poll();
                    for (int i = 0; i < graph[currNode].length; i++) {
                        if (colors[graph[currNode][i]] == colors[currNode]) {
                            return false;
                        }

                        if (colors[graph[currNode][i]] != 0) {
                            continue;
                        }

                        colors[graph[currNode][i]] = colors[currNode] == 1 ? 2 : 1;
                        q.add(graph[currNode][i]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite bg = new IsGraphBipartite();
        System.out.println(bg.isBipartite(new int[][]
                {{1,2,3},
                {0,2},
                {0,1,3},
                {0,2}})); // false

        System.out.println(bg.isBipartite(new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}})); // true

        System.out.println(bg.isBipartite(new int[][]{
                {1},
                {0, 3},
                {3},
                {1, 2}})); // true

        // disconnected graphs
        System.out.println(bg.isBipartite(new int[][]{
                {1},
                {0},
                {3, 4},
                {2, 4},
                {2, 3}
                })); // false

        System.out.println(bg.isBipartite(new int[][]{
                {},
                {},
                {},
                {},
                {}
        })); // true

        System.out.println(bg.isBipartite(new int[][]{
                {3},
                {4},
                {},
                {0},
                {1}
        })); // true
    }
}
