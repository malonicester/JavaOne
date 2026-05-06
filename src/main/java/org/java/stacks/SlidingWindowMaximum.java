package org.java.stacks;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = slidingWindowMaximum(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] slidingWindowMaximum(int[] arr, int k) {
        int[] maxArray = new int[arr.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i >= k - 1) {
                maxArray[index++] = dq.poll();
            }
            if(dq.size() >= k) dq.pollFirst();
            if (dq.isEmpty() || arr[i] <= dq.peekFirst()) {
                dq.addFirst(arr[i]);
            } else {
                dq.addLast(arr[i]);
            }
        }
        return maxArray;
    }
}
