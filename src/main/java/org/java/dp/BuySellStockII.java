package org.java.dp;

import java.util.Arrays;

public class BuySellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int[][] dp = new int[prices.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }


        int ans = buySell2(prices, 0, 1, dp);
        System.out.println(ans);
    }

    public static int buySell2(int[] arr, int index, int status, int[][] dp) {
        if (index >= arr.length) return 0;
        if (dp[index][status] != -1) return dp[index][status];
        if (status == 1) {
            int option1 = -arr[index] + buySell2(arr, index + 1, 0, dp);
            int option2 = buySell2(arr, index + 1, 1, dp);
            return dp[index][status] = Math.max(option1, option2);
        }
        int option1 = arr[index] + buySell2(arr, index + 1, 1, dp);
        int option2 = buySell2(arr, index + 1, 0, dp);
        return dp[index][status] = Math.max(option1, option2);
    }
}
