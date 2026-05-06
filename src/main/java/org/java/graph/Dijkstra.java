package org.java.graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int v = 3;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 3},
                {0, 2, 6}
        };
        int src = 2;
        int[] ans = dijkstraUsingPriorityQueue(v, edges, src);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] dijkstraUsingPriorityQueue(int V, int[][] edges, int src) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Pair<>(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Pair<>(edge[0], edge[2]));
        }

        return dijkstraWithSet(adjList, src);
    }

    private static int[] dijkstraUsingPriorityQueue(List<List<Pair<Integer, Integer>>> adj, int src) {
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (!a.getKey().equals(b.getKey())) return Integer.compare(a.getKey(), b.getKey());
            return a.value.compareTo(b.value);
        });
        // Key Of Pair is distance taken to reach node(value of pair)
        queue.offer(new Pair<>(0, src));
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> element = queue.poll();
            Integer currentDistance = element.getKey();
            Integer node = element.getValue();
            for (Pair<Integer, Integer> nodeWeightPair : adj.get(node)) {
                Integer adjacentNode = nodeWeightPair.getKey();
                Integer edgeWeight = nodeWeightPair.getValue();
                if (distance[adjacentNode] > currentDistance + edgeWeight) {
                    distance[adjacentNode] = currentDistance + edgeWeight;
                    queue.offer(new Pair<>(currentDistance + edgeWeight, adjacentNode));
                }
            }
        }
        return distance;
    }

    private static int[] dijkstraWithSet(List<List<Pair<Integer, Integer>>> adj, int src) {
        TreeSet<Pair<Integer, Integer>> set =
                new TreeSet<>((a, b) -> {
                    if (!a.getKey().equals(b.getKey())) return Integer.compare(a.getKey(), b.getKey());
                    return a.value.compareTo(b.value);
                }
                );
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        set.add(new Pair<>(0, src));
        while (!set.isEmpty()) {
            Pair<Integer, Integer> nodeDistancePair = set.pollFirst();
            Integer currentDistance = nodeDistancePair.getKey();
            Integer node = nodeDistancePair.getValue();
            for (Pair<Integer, Integer> nodeWeightPair : adj.get(node)) {
                Integer adjacentNode = nodeWeightPair.getKey();
                Integer edgeWeight = nodeWeightPair.getValue();
                if (edgeWeight + currentDistance < distance[adjacentNode]) {
                    if (distance[adjacentNode] != Integer.MAX_VALUE) {
                        // Saves Iteration as it is reached by some node earlier and not valid from now because we got a lower value
                        set.remove(new Pair<>(distance[adjacentNode], adjacentNode));
                    }
                    distance[adjacentNode] = edgeWeight + currentDistance;
                    set.add(new Pair<>(edgeWeight + currentDistance, adjacentNode));
                }
            }
        }
        return distance;
    }
}


