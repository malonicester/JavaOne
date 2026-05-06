package org.java.slidingWindow;

public class LongestSubArrayDeletingOneElement {

    public static void main(String[] args) {
        int [] arr = {0,1,1,1,0,1,1,0,1};
        int ans = longestSubArrayDeletingOneElement(arr);
        System.out.println(ans);
    }
    private static int longestSubArrayDeletingOneElement(int[] arr){
        int i = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (arr[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen - 1;
    }
}
