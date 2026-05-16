package org.java.dp;

public class ShortestSubSequence {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        String ans = shortestCommonSupersequence(str1, str2);
        System.out.println(ans);
    }


    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int start = n, end = m;
        StringBuilder sb = new StringBuilder();
        while (start > 0 && end > 0) {
            // If Both Characters Match, we add `1` character and move diagonally Up
            if (str1.charAt(start - 1) == str2.charAt(end - 1)) {
                sb.append(str1.charAt(start - 1));
                start--;
                end--;
            }
            // If coming from top has higher value, take character from str1
            else if (dp[start - 1][end] > dp[start][end - 1]) {
                sb.append(str1.charAt(start - 1));
                start--;
            }
            // Otherwise, take character from str2
            else {
                sb.append(str2.charAt(end - 1));
                end--;
            }
        }

        while (start > 0) {
            sb.append(str1.charAt(start - 1));
            start--;
        }
        while (end > 0) {
            sb.append(str2.charAt(end - 1));
            end--;
        }
        return sb.reverse().toString();
    }


    private static String shortestCommonSupersequence(String str1, String str2, int i, int j, String[][] dp) {
        if (i >= str1.length() && j >= str2.length()) {
            return "";
        }
        if (i >= str1.length()) {
            return str2.substring(j);
        }
        if (j >= str2.length()) {
            return str1.substring(i);
        }

        if (dp[i][j] != null) return dp[i][j];

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = str1.charAt(i) + shortestCommonSupersequence(str1, str2, i + 1, j + 1, dp);
        }
        String option1 = str1.charAt(i) + shortestCommonSupersequence(str1, str2, i + 1, j, dp);
        String option2 = str2.charAt(j) + shortestCommonSupersequence(str1, str2, i, j + 1, dp);
        if (option1.length() > option2.length()) return dp[i][j] = option2;
        return dp[i][j] = option1;
    }

}
