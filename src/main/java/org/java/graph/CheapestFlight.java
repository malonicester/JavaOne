package org.java.graph;

import java.util.*;

public class CheapestFlight {

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dest = 3, k = 1;
        int ans = cheapestFlightWithKStops(4, flights, src, dest, k);
        System.out.println(ans);
    }

    public static int cheapestFlightWithKStops(int n, int[][] flights, int src, int dest, int k) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] path : flights) {
            adj.get(path[0]).add(new Pair<>(path[1], path[2]));
        }
        int[] dist = new int[flights.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> queue = new LinkedList<>(); // As we are moving linearly i.e greedy by stops and also considering minimizing the distance on that path
        // Stops , Node , Distance
        queue.offer(new int[]{0, src, 0});
        while (!queue.isEmpty()) {
            int[] currentDetails = queue.poll();
            int currentStops = currentDetails[0];
            int currentNode = currentDetails[1];
            int currentNodeDistance = currentDetails[2];
            if (currentStops > k) break; //  No Need To Check Further as we are moving linearly one level after other
            for (Pair<Integer, Integer> pair : adj.get(currentNode)) {
                int node = pair.getKey();
                int nodeDistance = pair.getValue();
                if (currentNodeDistance + nodeDistance < dist[node]) {
                    dist[node] = nodeDistance + currentNodeDistance;
                    queue.offer(new int[]{currentStops + 1, node, dist[node]});
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}
