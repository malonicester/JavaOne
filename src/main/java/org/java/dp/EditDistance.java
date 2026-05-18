package org.java.dp;

public class EditDistance {
    public static void main(String[] args) {
        String w1 = "horse", w2 = "ros";
        int ans = minimumEditDistance(w1, w2);
        System.out.println(ans);
    }

    private static int minimumEditDistance(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace
                            Math.min(
                                    dp[i - 1][j], // Delete
                                    dp[i][j - 1]  // Add
                            )
                    );
                }
            }
        }
        return dp[n][m];
    }


    private static int editDistance(String w1, String w2, int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (w1.charAt(i) == w2.charAt(j)) {
            return editDistance(w1, w2, i - 1, j - 1);
        }
        return 1 + Math.min(
                editDistance(w1, w2, i - 1, j - 1), // Replace
                Math.min(
                        editDistance(w1, w2, i - 1, j), // Delete
                        editDistance(w1, w2, i, j - 1) // Add
                ));
    }

}


class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length, max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(
                                dp[i - 1][j],
                                Math.min(
                                        dp[i][j - 1],
                                        dp[i - 1][j - 1]
                                )
                        );
                    }
                }
            }
        }
      return max;
    }
}