package org.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectionInANetwork {
    public static void main(String[] args) {

    }

    private int timer = 1;

    private List<List<Integer>> numberOfConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> list : connections) {
            adjList.get(list.get(0)).add(list.get(1));
            adjList.get(list.get(1)).add(list.get(0));
        }
        int[] discover = new int[n], lowest = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(adjList, 0, -1, discover, lowest, bridges, visited);
        return bridges;
    }

    private void dfs(List<List<Integer>> adjList, int node, int parent, int[] discover, int[] lowest, List<List<Integer>> bridges, boolean[] visited) {
        discover[node] = lowest[node] = timer;
        visited[node] = true;
        timer++;
        for (int neighbour : adjList.get(node)) {
            if (neighbour == parent) continue;
            if (!visited[neighbour]) {
                dfs(adjList, neighbour, node, discover, lowest, bridges, visited);
                if (lowest[neighbour] > lowest[node]) {
                    bridges.add(List.of(neighbour, node));
                }
            } else {
                lowest[neighbour] = Math.min(discover[neighbour], lowest[node]);
            }
        }
    }
}
