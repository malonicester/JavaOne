package org.java.BinaryTrees;

public class SearchInRotatedArray {
    public static void main(String[] args) {

    }

    private static int findElementInRotatedSortedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            // When arr[start] <= arr[mid] left half is sorted <= is because when start == mid
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    private static int findElementInRotatedSortedArrayII(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            // When arr[start] <= arr[mid] left half is sorted <= is because when start == mid
            if (arr[start] <= arr[mid]) {
                if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                    start++;
                    end--;
                } else if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                    start++;
                    end--;
                } else if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
