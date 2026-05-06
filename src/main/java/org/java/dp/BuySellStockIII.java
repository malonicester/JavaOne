package org.java.dp;

import java.util.Arrays;

public class BuySellStockIII {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int ans = buySellStockIII(arr);
        System.out.println(ans);
    }


    public static int buySellStockIII(int[] arr) {
        int[][][] dp = new int[arr.length + 1][3][2];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return buySellStock(arr, 0, 0, 1, dp);
    }

    private static int buySellStock(int[] arr, int index, int numberOfTransactions, int status, int[][][] dp) {
        if (numberOfTransactions == 2 || index >= arr.length) return 0;
        if (dp[index][numberOfTransactions][status] != -1) return dp[index][numberOfTransactions][status];
        if (status == 1) {
            int option1 = -arr[index] + buySellStock(arr, index + 1, numberOfTransactions, 0, dp);
            int option2 = buySellStock(arr, index + 1, numberOfTransactions, 1, dp);
            return dp[index][numberOfTransactions][status] = Math.max(option1, option2);
        }

        int option1 = arr[index] + buySellStock(arr, index + 1, numberOfTransactions + 1, 1, dp);
        int option2 = buySellStock(arr, index + 1, numberOfTransactions, 0, dp);
        return dp[index][numberOfTransactions][status] = Math.max(option1, option2);
    }
}
