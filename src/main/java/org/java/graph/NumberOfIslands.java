package org.java.graph;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public static int numberOfIslands(char[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == '1' && !visited[i][j]) {
                    dfs(arr, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) return;
        if (arr[i][j] == '0') return;
        visited[i][j] = true;
        dfs(arr, i, j + 1, visited);
        dfs(arr, i, j - 1, visited);
        dfs(arr, i - 1, j, visited);
        dfs(arr, i + 1, j, visited);
    }
}
