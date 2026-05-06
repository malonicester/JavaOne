package org.java.dp;

public class LengthOfLongestVShaped {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 2, 0, 2, 0, 0},
                {0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        int ans = lengthOfLongestVShapedDiagonal(arr);
        System.out.println(ans);
    }

    private static int lengthOfLongestVShapedDiagonal(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    int[] values = getValues(arr, i, j);
                    if (values != null) {
                        int newI = values[0];
                        int newJ = values[1];
                        max = 1 + Math.max(lengthOfLongestVShaped(arr, newI, newJ, -1, -1,0, false), max);
                    }
                }
            }
        }
        return max;
    }

    private static final int[][] directions = {
            {1, 1},
            {-1, 1},
            {1, -1},
            {-1, -1},
    };

    private static int lengthOfLongestVShaped(int[][] arr, int i, int j, int prevDirectionI, int prevDirectionJ, int prevNumber, boolean hasTakenTurn) {
        if (!isValid(arr, i, j)) return 0;
        if (arr[i][j] != prevNumber && (arr[i][j] == 0 || arr[i][j] == 2)) {
            int maxLength = 0;
            boolean isTurn = false;
            for (int[] direction : directions) {
                int newI = i + direction[0];
                int newJ = j + direction[1];
                if (prevDirectionI != -1 && prevDirectionJ != -1) {
                    if (prevDirectionI != direction[0] || prevDirectionJ != direction[1]) {
                        isTurn = true;
                    }
                }
                if (hasTakenTurn && isTurn) return 0;
                maxLength = Math.max(1 + lengthOfLongestVShaped(arr, newI, newJ, direction[0], direction[1], arr[i][j], hasTakenTurn || isTurn), maxLength);
            }
            return maxLength;
        } else {
            return 0;
        }
    }

    private static boolean isValid(int[][] arr, int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[i].length ;
    }

    private static int max(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int[] getValues(int[][] arr, int i, int j) {
        if (isValid(arr, i + 1, j + 1)) {
            if (arr[i + 1][j + 1] == 2) {
                return new int[]{i + 1, j + 1};
            }
        }
        if (isValid(arr, i - 1, j - 1)) {
            if (arr[i - 1][j - 1] == 2) {
                return new int[]{i - 1, j - 1};
            }
        }
        if (isValid(arr, i + 1, j - 1)) {
            if (arr[i + 1][j - 1] == 2) {
                return new int[]{i + 1, j - 1};
            }
        }
        if (isValid(arr, i - 1, j + 1)) {
            if (arr[i - 1][j + 1] == 2) {
                return new int[]{i - 1, j + 1};
            }
        }
        return null;
    }
}
