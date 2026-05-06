package org.java.binarysearch;

public class SearchInARotatedArray2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 4, 4, 1, 2, 2, 2, 2, 2};
        boolean ans = searchInARotatedArray(arr, 1);
        System.out.println(ans);
    }

    private static boolean searchInARotatedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return true;
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }


}
