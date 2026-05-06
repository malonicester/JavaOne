package org.java.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumCostToReachDestination {


    public static void main(String[] args) {
//        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {0, 3, 10},
                {1, 3, 2},
                {3, 2, 2},
                {4, 3, 1}
        };;
        int[] passingFees = {1,1,3,2,1};
        int maxTime = 10;
        int minimumCostToReachDestination = minimumCostToReachDestination(maxTime, edges, passingFees);
        System.out.println(minimumCostToReachDestination);
    }

    private static int minimumCostToReachDestination(int maxTime, int[][] edges, int[] passingFees) {
        List<List<int[]>> adj = getAdjList(edges,passingFees);
        int[] cost = new int[passingFees.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = passingFees[0];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{passingFees[0], 0, 0});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int currentPassingTime = arr[2];
            int currentNode = arr[1];
            int currentNodeCost = arr[0];

            if (currentPassingTime > maxTime) {
                continue;
            }
            for (int[] edgeDetails : adj.get(currentNode)) {
                int node = edgeDetails[0];
                int nodeTime = edgeDetails[1];
                if (nodeTime + currentPassingTime <=maxTime && currentNodeCost + passingFees[node] < cost[node]) {
                    cost[node] = currentNodeCost + passingFees[node];
                    queue.offer(new int[]{cost[node], node, currentPassingTime + nodeTime});
                }
            }
        }
        return cost[passingFees.length - 1] == Integer.MAX_VALUE ? -1 : cost[passingFees.length - 1];
    }

    private static List<List<int[]>> getAdjList(int[][] edges,int[]passingFees) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < passingFees.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            list.get(edge[0]).add(new int[]{edge[1], edge[2]});
            list.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return list;
    }
}
