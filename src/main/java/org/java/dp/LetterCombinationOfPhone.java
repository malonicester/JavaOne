package org.java.dp;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {
    static String[] phone = {"", "", "abc", "def", "ijk", "lmn", "opq", "rst", "uvw", "xyz"};

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        letterCombinations("234", new StringBuilder(), list, 0);
        System.out.println(list);
    }

    public static void letterCombinations(String digits, StringBuilder builder, List<String> result, int index) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }
        String letters = phone[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            builder.append(letters.charAt(i));
            letterCombinations(digits, builder, result, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
