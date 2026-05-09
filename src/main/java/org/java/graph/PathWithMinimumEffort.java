package org.java.graph;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        int ans = pathWithMiniumEffort(arr);
        System.out.println(ans);
    }

    private static final int[][] paths = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };

    private static int pathWithMiniumEffort(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] maxAbsoluteDifference = new int[n][m];
        for (int[] a : maxAbsoluteDifference) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        maxAbsoluteDifference[0][0] = 0;
        Queue<Pair<Integer, Pair<Integer, Integer>>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        queue.offer(new Pair<>(0, new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> pair = queue.poll();
            int maxAbsoluteDifferenceDistance = pair.key;
            int row = pair.value.key;
            int col = pair.value.value;
            if (row == n - 1 && col == m - 1) return maxAbsoluteDifferenceDistance;
            for (int i = 0; i < paths.length; i++) {
                int[] path = paths[i];
                int r = path[0], c = path[1];
                if (isValidPath(arr, row + r, col + c)) {
                    int maxAbsoluteDiff = Math.max(Math.abs(arr[row][col] - arr[r + row][c + col]), maxAbsoluteDifferenceDistance);
                    if (maxAbsoluteDiff < maxAbsoluteDifference[r + row][c + col]) {
                        maxAbsoluteDifference[r + row][c + col] = maxAbsoluteDiff;
                        queue.offer(new Pair<>(maxAbsoluteDifference[r + row][c + col], new Pair<>(r + row, c + col)));
                    }
                }
            }
        }

        return maxAbsoluteDifference[n - 1][m - 1];
    }

    private static boolean isValidPath(int[][] arr, int i, int j) {
        return (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length);
    }
}
