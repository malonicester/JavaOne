package org.java.dp;

import java.util.Arrays;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -1, 1, 2, 3, 5};
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = longestIncreasingSubSeq(arr, dp, n, 0, -1);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(result);
    }

    private static int longestIncreasingSubSeq(int[] arr, int[][] dp, int n, int index, int prev) {
        if (index == n) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];

        int max = longestIncreasingSubSeq(arr, dp, n, index + 1, prev);
        if (prev == -1 || arr[index] > arr[prev]) {
            max = Math.max(
                    1 + longestIncreasingSubSeq(arr, dp, n, index + 1, index),
                    max
            );
        }
        return dp[index][prev + 1] = max;
    }
}
