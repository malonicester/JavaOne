package org.java.binarysearch;

import java.util.Arrays;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2};
        boolean predict = predict(arr);
        System.out.println(predict);
    }


    public static boolean predict(int[] arr) {
        int sum = 0;
        for (int a : arr)
            sum += a;
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        int ans = help(arr, 0, arr.length - 1, dp);
        System.out.println(ans);
        return ans >= sum - ans;
    }

    public static int help(int[] arr, int s, int e,int [][] dp) {
        if (s > e) return 0;
        if (s == e) return arr[s];
        if(dp[s][e] != -1) return dp[s][e];
        int option1 = arr[s] + Math.min(help(arr, s + 2, e,dp), help(arr, s + 1, e - 1,dp));
        int option2 = arr[e] + Math.min(help(arr, s, e - 2,dp), help(arr, s + 1, e - 1,dp));
        return dp[s][e] = Math.max(option1, option2);
    }
}
