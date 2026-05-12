package org.java;

import java.util.Arrays;

public class FloorOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,1};
        int x = 1;
        System.out.println(findFloor(arr, x));
        System.out.println(findCeil(arr, x));

        int[] arr2 = {1, 2, 3, 3, 3, 3, 3, 3, 4};
        System.out.println(Arrays.toString(firstAndLastOccuranceOfElement(arr2, 3)));
    }

    public static int findFloor(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }


    public static int findCeil(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int[] firstAndLastOccuranceOfElement(int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstOccurance(arr, target);
        ans[1] = findLastOccurance(arr, target);
        return ans;
    }

    private static int findFirstOccurance(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }


    private static int findLastOccurance(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
