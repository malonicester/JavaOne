package org.java.BinaryTrees;


import java.util.*;

public class CheapestFlightWithKStops {

    public static void main(String[] args) {

        int[][] arr = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int n = 4;
        int src = 0, dst = 3, k = 1;
        int ans = cheapestFlightWithInKStopsDijkstra(n, arr, src, dst, k);
        System.out.println(ans);
    }

    private static int cheapestFlightWithInKStops(int n, int[][] arr, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            adjList.get(arr[i][0]).add(new Pair<>(arr[i][1], arr[i][2]));
        }

        int minPrice = Integer.MAX_VALUE;

        Queue<Pair<Integer, Pair<Integer, Integer>>> queue = new LinkedList<>();

        queue.offer(new Pair<>(src, new Pair<>(0, -1)));

        while (!queue.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> pair = queue.poll();
            int node = pair.key;
            Pair<Integer, Integer> right = pair.value;
            int price = right.key;
            int stops = right.value;
            if (stops <= k && dst == node) {
                minPrice = Math.min(minPrice, price);
            }
            if (stops > k) continue;

            for (Pair<Integer, Integer> p : adjList.get(node)) {
                queue.offer(new Pair<>(p.key, new Pair<>(price + p.value, stops + 1)));
            }
        }
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }


    private static int cheapestFlightWithInKStopsDijkstra(int n, int[][] arr, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            adjList.get(arr[i][0]).add(new Pair<>(arr[i][1], arr[i][2]));
        }

        int[] costArr = new int[n + 1];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[src] = 0;
        Queue<Pair<Integer, Pair<Integer, Integer>>> queue = new LinkedList<>();
//                             cost          src   stop
        queue.offer(new Pair<>(0, new Pair<>(src, 0)));

        while (!queue.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> pair = queue.poll();
            int cost = pair.key;
            int node = pair.value.key;
            int stop = pair.value.value;

            if (stop > k) continue;

            for (Pair<Integer, Integer> p : adjList.get(node)) {
                if (p.value + cost < costArr[p.key]) {
                    costArr[p.key] = p.value + cost;
                    queue.offer(new Pair<>(p.value + cost, new Pair<>(p.key, stop + 1)));
                }
            }

        }
        return costArr[dst] != Integer.MAX_VALUE ? costArr[dst] : -1;
    }


    private static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
