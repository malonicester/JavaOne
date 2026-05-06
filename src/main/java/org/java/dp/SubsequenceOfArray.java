package org.java.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsequenceOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        List<List<Integer>> lists = subSequence(arr);
//        System.out.println(lists);
        List<List<Integer>> permutations = new ArrayList<>();
        permutationWithSwap(arr, 0, permutations);
        System.out.println(permutations);
    }

    public static List<List<Integer>> subSequence(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        if (index >= arr.length) return;
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            helper(arr, i + 1, current, result);
            current.removeLast();
        }
    }


    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        permutations(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private static void permutations(int[] nums, List<List<Integer>> ans, List<Integer> current, boolean[] visited) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            permutations(nums, ans, current, visited);
            visited[i] = false;
            current.removeLast();
        }
    }

    private static void permutationWithSwap(int[] nums, int start, List<List<Integer>> ans) {
        ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            System.out.println(Arrays.toString(nums) + " " + i + " " + start);
            permutationWithSwap(nums, start + 1, ans);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
