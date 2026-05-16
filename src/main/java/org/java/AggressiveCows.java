package org.java;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int ans = aggressiveCows(arr, 3);
        System.out.println(ans);
    }

    private static int aggressiveCows(int[] arr, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        System.out.printf("Min %d Max %d \n", min, max);
        int start = 1, end = max - min, ans = 0;
        for (int i = start; i <= end; i++) {
            if (canPlaceCows(arr, i, k)) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    private static boolean canPlaceCows(int[] arr, int distance, int k) {
        int lastPlaceCow = arr[0], numberOfCows = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlaceCow >= distance) {
                numberOfCows++;
                lastPlaceCow = arr[i];
            }
        }
        return numberOfCows >= k;
    }
}
