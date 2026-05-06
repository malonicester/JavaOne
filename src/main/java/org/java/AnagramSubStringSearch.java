package org.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSubStringSearch {
    public static void main(String[] args) {
        String text = "BACDGABCDA";
        String pat = "ABCD";
        System.out.println(Arrays.toString(substringAnagramSearch(text, pat)));
    }

    private static int[] substringAnagramSearch(String text, String pattern) {
        int[] patArr = new int[26];
        for (char ch : pattern.toCharArray()) {
            patArr[ch - 65]++;
        }
        int j = 0;
        List<Integer> list = new ArrayList<>();
        int[] textArr = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = ch - 65;
            textArr[index]++;
            if (patArr[index] == 0) {
                Arrays.fill(textArr, 0);
                j = i + 1;
                continue;
            }
            if (i - j + 1 > pattern.length()) {
                char jthChar = text.charAt(j);
                int jthIndex = jthChar - 65;
                textArr[jthIndex] = Math.max(0, --textArr[jthIndex]);
                j++;
            }

            if (Arrays.equals(textArr, patArr)) {
                list.add(j);
            }

        }
        return list.stream().mapToInt(i -> i).toArray();
    }


    public static List<Integer> substringAnagram(String text, String pattern) {
        int[] freq = new int[26];
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (char ch : pattern.toCharArray()) {
            freq[ch - 97]++;
            count++;
        }

        int left = 0, right = 0;
        while (right < text.length()) {
            int index = text.charAt(right) - 65;
            if (freq[index] > 0) {
                count--;
            }
            freq[index]--;
            right++;

            if (right - left > pattern.length()) {
                char l = text.charAt(left);
                if (freq[l - 65] >= 0) {
                    count++;
                }
                freq[l - 65]++;
                left++;
            }


            if (freq[index] == 0) {
                freq[index]++;
                count++;
            }


            if (count == 0) {
                list.add(left);
            }
        }
        return list;
    }
}
