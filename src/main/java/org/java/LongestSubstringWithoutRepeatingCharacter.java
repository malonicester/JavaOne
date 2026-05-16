package org.java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcdbacdefbcde";
        int ans = longestSubStringWithoutRepeatingCharacter(str);
        System.out.println(ans);
    }

    private static int longestSubStringWithoutRepeatingCharacter(String str) {
        int i = 0, j = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (j < str.length()) {
            char ch = str.charAt(j);
//            while loop will run from i untill the character ch not get removed
            while (set.contains(ch)) {
                char iThChar = str.charAt(i);
                set.remove(iThChar);
                i++;
            }
            set.add(ch);
            maxLength = Math.max(j - i + 1, maxLength);
            j++;
        }
        return maxLength;
    }
}

class Tuple {

    int first;
    int second;
    double third;

    public Tuple(int first, int second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String toString() {
        return "{" + this.first + " " + this.second + " " + this.third + "}";
    }
}