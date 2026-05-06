package org.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {5, 10}, {2, 6}, {15, 18}};
        mergeOverLappingIntervals(arr);
    }

    private static int mergeOverLappingIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] > b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        List<int[]> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < arr.length; i = i + j) {
            int[] a = new int[2];
            a[0] = arr[i][0];
            int value = arr[i][1];
            while (j < arr.length && value > arr[j][0]) {
                j++;
            }
            a[1] = arr[j][1];
            list.add(a);
        }
        System.out.println("==============");
        for (int[] v : list) {
            System.out.println(Arrays.toString(v));
        }
        return 0;
    }
}
