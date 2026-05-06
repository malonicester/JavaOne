package org.java.slidingWindow;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int ans = maxAreaD(arr);
        System.out.println(ans);
    }

    private static int maxAreaD(int[] height) {
        int[] prefixArray = new int[height.length];
        int[] suffixArray = new int[height.length];
        prefixArray[0] = 0;
        suffixArray[height.length - 1] = height.length - 1;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[prefixArray[i - 1]]) {
                prefixArray[i] = i;
            } else {
                prefixArray[i] = prefixArray[i - 1];
            }
        }
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > height[suffixArray[i + 1]]) {
                suffixArray[i] = i;
            } else {
                suffixArray[i] = suffixArray[i + 1];
            }
        }
        System.out.println(Arrays.toString(prefixArray));
        System.out.println(Arrays.toString(suffixArray));
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int prefMax = prefixArray[i];
            int suffixMax = suffixArray[i];
            int maxHeight = Math.min(height[prefMax], height[suffixMax]);
            int area = Math.abs(prefMax - suffixMax) * maxHeight;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
