package org.java.dp;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[][] dp = new int[3][6];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = change(new int[]{1, 2, 5}, 5, 0, dp);
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(ans);
    }

    public static int change(int[] arr, int amount, int index) {
        if (amount < 0) return 0;
        if (amount == 0) {
            return 1;
        }
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            count += change(arr, amount - arr[i], i);
        }
        return count;
    }


    public static int change(int[] arr, int amount, int index, int[][] dp) {
        if (amount < 0) return 0;
        if (dp[index][amount] != -1) return dp[index][amount];
        if (amount == 0) {
            return 1;
        }
        int count = 0;
        for (int i = index; i < arr.length; i++) {
            count += change(arr, amount - arr[i], i, dp);
        }
        return dp[index][amount] = count;
    }


}
