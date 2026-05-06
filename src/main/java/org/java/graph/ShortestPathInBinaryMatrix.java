package org.java.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {

        /*
        {1, 1 ,1, 1, 1}
{1, 1, 1, 1, 1}
{1, 1 ,1 ,1, 0}
{1 ,0 ,1, 0, 1}
         */
        int[][] grid = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        int[] src = {0, 1};
        int[] dst = {2, 2};
        int ans = shortestPathInBinaryMatrix(grid, src, dst);
        System.out.println(ans);
    }

    static int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private static int shortestPathInBinaryMatrix(int[][] matrix, int[] src, int[] dst) {
        // No Need to use priority queue because it is already moving a unit distance only we can save a log n time complexity here of priority queue
        Queue<Pair<Integer, Pair<Integer, Integer>>> pq = new LinkedList<>();
        int[][] distance = new int[matrix.length][matrix[0].length];
        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        distance[src[0]][src[1]] = 0;
        pq.offer(new Pair<>(0, new Pair<>(src[0], src[1])));

        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> pair = pq.poll();
            int currentDistance = pair.getKey();
            Pair<Integer, Integer> rowColPair = pair.getValue();
            int currentRow = rowColPair.getKey();
            int currentCol = rowColPair.getValue();
            for (int[] dir : dir) {
                int nextRow = currentRow + dir[0];
                int nextCol = currentCol + dir[1];
                if (isValid(matrix, nextRow, nextCol) && matrix[nextRow][nextCol] == 1) {
                    if (distance[nextRow][nextCol] > currentDistance + 1) {
                        distance[nextRow][nextCol] = currentDistance + 1;
                        if (nextRow == dst[0] && nextCol == dst[1]) return distance[nextRow][nextCol];
                        pq.offer(new Pair<>(distance[nextRow][nextCol], new Pair<>(nextRow, nextCol)));
                    }
                }
            }
        }
        return distance[dst[0]][dst[1]] == Integer.MAX_VALUE ? -1 : distance[dst[0]][dst[1]];
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
