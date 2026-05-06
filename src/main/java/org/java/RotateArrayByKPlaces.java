package org.java;

import java.util.Arrays;

public class RotateArrayByKPlaces {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;

        rotateArrayByKPlaces(arr, k);
    }

    public static void rotateArrayByKPlaces(int[] arr, int k) {
        k = k % arr.length;
        int i = 0, j = arr.length - k;
        while (j < arr.length) {
            swap(arr, i++, j++);
        }
        System.out.println(Arrays.toString(arr));
        i = k;
        while (i < arr.length - 1) {
            swap(arr, i, i + 1);
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
