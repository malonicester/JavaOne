package org.java.dp;

import java.util.Arrays;

public class StoneGame {

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 3};
        boolean b = stoneGame(arr);
        System.out.println(b);
    }

    public static boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int num : piles) {
            sum += num;
        }
        int[][] dp = new int[piles.length][piles.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans = collectStone(piles, 0, piles.length - 1, dp);
        return ans > sum - ans;
    }

    public static int collectStone(int[] arr, int s, int e, int[][] dp) {
        if (s > e) return 0;
        if (dp[s][e] != -1) return dp[s][e];
        int option1 = arr[s] + Math.min(collectStone(arr, s + 2, e, dp), collectStone(arr, s + 1, e - 1, dp));
        int option2 = arr[e] + Math.min(collectStone(arr, s + 1, e - 1, dp), collectStone(arr, s, e - 2, dp));
        return dp[s][e] = Math.max(option1, option2);
    }
}
