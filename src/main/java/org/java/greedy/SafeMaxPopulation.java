package org.java.greedy;

import java.util.Arrays;

public class SafeMaxPopulation {
    public static void main(String[] args) {
        int[] arr = {20, 10, 9, 30, 20, 19};
        String unit = "011011";
        int ans = saveMaxPopulation(arr, unit);
        System.out.println(ans);
    }

    public static int saveMaxPopulation(int[] arr, String unit) {
        int total = 0;

        char[] units = unit.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            if (units[i] == '0' && units[i + 1] == '1') {
                if (arr[i] > arr[i + 1]) {
                    units[i] = '1';
                    units[i + 1] = '0';
                }
            }
        }

        System.out.println(Arrays.toString(units));


        for (int i = 0; i < arr.length; i++) {
            if (units[i] == '1') {
                total += arr[i];
            }
        }

        return total;
    }
}
