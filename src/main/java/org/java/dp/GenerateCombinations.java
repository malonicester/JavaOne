package org.java.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateCombinations {
    public static void main(String[] args) {
        List<List<Integer>> lists = generateCombinations(4, 2);
        System.out.println(lists);
    }


    public static List<List<Integer>> generateCombinations(int num, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, num, result, new ArrayList<>());
        return result;
    }

    private static void helper(int num, int k, int limit, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = num; i <= limit; i++) {
            current.add(i);
            helper(i + 1, k, limit, result, current);
            current.removeLast();
        }
    }
}
