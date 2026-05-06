package org.java.binarysearch;

public class MinimizeNumberOfMoneySpend {
    public static void main(String[] args) {
        int minimize = minimize(null);
        System.out.println(
                minimize
        );
    }

    public static int minimize(int[][] arr) {
        int[][] dp = {
                {1, 50, 50},
                {50, 50, 50},
                {1, 50, 50}
        };
        int help = help(dp, 0, 3);
        return help;
    }

    public static int help(int[][] arr, int index, int prev) {
        if (index == arr.length) return 0;
        int option1 = Integer.MAX_VALUE;
        int option2 = Integer.MAX_VALUE;
        int option3 = Integer.MAX_VALUE;
        if (prev != 0) {
            option1 = arr[index][0] + help(arr, index + 1, 0);
        }
        if (prev != 1) {
            option2 = arr[index][1] + help(arr, index + 1, 1);
        }
        if (prev != 2) {
            option3 = arr[index][2] + help(arr, index + 1, 2);
        }
        return Math.min(option1, Math.min(option2, option3));
    }
}
