package org.java.dp;

import org.java.graph.Pair;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String str = "cbbd";
        String ans = longestPalindromicSubString(str);
        System.out.println(ans);
    }

    private static int palindromicSubStrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += palindrome(str, i, i);
            count += palindrome(str, i, i + 1);
        }
        return count;
    }

    private static int palindrome(String str, int i, int j) {
        int count = 0;
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }

    private static String longestPalindromicSubString(String str) {
        int maxLength = 0;
        Pair<Integer, Integer> maxLengthPair = null;
        for (int i = 0; i < str.length(); i++) {
            Pair<Integer, Integer> pair = lengthOfLongestPalindrome(str, i, i);
            if (pair != null) {
                int length = pair.getValue() - pair.getKey() + 1;
                if(length > maxLength) {
                    maxLength = length;
                    maxLengthPair = pair;
                }
            }

             pair = lengthOfLongestPalindrome(str, i, i + 1);
            if (pair != null) {
                int length = pair.getValue() - pair.getKey() + 1;
                if(length > maxLength) {
                    maxLength = length;
                    maxLengthPair = pair;
                }
            }

        }
        int i = maxLengthPair.getKey();
        int j = maxLengthPair.getValue();
        return str.substring(i,j + 1);
    }

    private static Pair<Integer, Integer> lengthOfLongestPalindrome(String str, int i, int j) {
        Pair<Integer, Integer> pair = null;
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            pair = Pair.createPair(i, j);
            i--;
            j++;
        }
        return pair;
    }
}
