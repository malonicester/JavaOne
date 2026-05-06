package org.java.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int ans = minimumEffortPath(arr);
        System.out.println(ans);
    }

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int minimumEffortPath(int[][] heights) {
        Queue<Pair<Integer, Pair<Integer, Integer>>> pq = new LinkedList<>();
        pq.offer(new Pair<>(0, new Pair<>(0, 0)));
        int[][] maxAbsoluteDifference = new int[heights.length][heights[0].length];
        for (int[] diff : maxAbsoluteDifference) {
            Arrays.fill(diff, Integer.MAX_VALUE);
        }
        maxAbsoluteDifference[0][0] = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> pair = pq.poll();
            Integer currentMaxAbsoluteDifference = pair.getKey();
            Pair<Integer, Integer> nodePair = pair.getValue();
            int row = nodePair.getKey();
            int col = nodePair.getValue();
            if(row == heights.length - 1 && col == heights[0].length - 1) return currentMaxAbsoluteDifference;
            for (int[] dir : dir) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (isValidPath(heights, nextRow, nextCol)) {
                    int maxAbsoluteDifferenceDistance = Math.max(Math.abs(heights[row][col] - heights[nextRow][nextCol]), currentMaxAbsoluteDifference);
                    if (maxAbsoluteDifferenceDistance < maxAbsoluteDifference[nextRow][nextCol]) {
                        maxAbsoluteDifference[nextRow][nextCol] = maxAbsoluteDifferenceDistance;
                        pq.offer(new Pair<>(maxAbsoluteDifferenceDistance, new Pair<>(nextRow, nextCol)));
                    }
                }
            }
        }
        return maxAbsoluteDifference[heights.length - 1][heights[0].length - 1];
    }

    private static boolean isValidPath(int[][] heights, int row, int col) {
        return row >= 0 && row < heights.length && col >= 0 && col < heights[0].length;
    }
}