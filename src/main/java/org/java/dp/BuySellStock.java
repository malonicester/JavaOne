package org.java.dp;

import java.util.Arrays;

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int ans = buySellStock(arr);
        System.out.println(ans);
    }

    public static int buySellStock(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return buySellStock(arr, 0, 1, dp);
    }

    private static int buySellStock(int[] arr, int index, int status, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][status] != -1) return dp[index][status];
        if (status == 1) {
            int option1 = -arr[index] + buySellStock(arr, index + 1, 0, dp);
            int option2 = buySellStock(arr, index + 1, 1, dp);
            return dp[index][status] = Math.max(option1, option2);
        }

        int option1 = arr[index];
        int option2 = buySellStock(arr, index + 1, 0, dp);
        return dp[index][status] = Math.max(option1, option2);
    }
}
