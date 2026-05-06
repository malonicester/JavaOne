package org.java.binarysearch;

import java.util.Arrays;

public class MaximumTastinessOfCandies {
    public static void main(String[] args) {
        int[] arr = {106, 195, 138, 127, 79, 119, 46, 198, 166, 10, 41, 151, 68, 198, 126, 46, 140, 35, 127};
        int k = 12;
        int ans = maximumTastiness(arr, k);
        System.out.println(ans);
    }

    public static int maximumTastiness(int[] arr, int k) {
        Arrays.sort(arr);
        int start = 0, end = arr[arr.length - 1] - start, ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossibleWithDDifference(arr, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleWithDDifference(int[] arr, int D, int k) {
        int count = 1, num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= num + D) {
                count++;
                num = arr[i];
            }
        }
        return count >= k;
    }
}
