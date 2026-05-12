package org.java;

public class TappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = tappingRainWater(arr);
        System.out.println(ans);
    }

    private static int tappingRainWater(int[] arr) {
        int total = 0, n = arr.length;
        int leftMax = 0, rightMax = 0, left = 0, right = n - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (leftMax <= rightMax) {
                total += leftMax - arr[left++];
            } else {
                total += rightMax - arr[right--];
            }
        }
        return total;
    }
}
