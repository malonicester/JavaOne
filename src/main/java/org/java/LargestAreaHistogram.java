package org.java;

import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        StringBuilder db = new StringBuilder();
        db.deleteCharAt(0);
    }


    private static int largestAreaHistogram(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i < arr.length;i++) {
            int current = arr[i];
            while(!st.isEmpty() && current < arr[st.peek()]) {
                int element = arr[st.pop()];
                int rightSmallerIndex = i;
                int leftSmallerIndex =  !st.isEmpty() ? st.peek() : -1; // as no smaller element exists towards the left we can expand till the very start
                int area = element * (rightSmallerIndex - leftSmallerIndex - 1);
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int element = arr[st.pop()];
            int rightSmallerIndex = arr.length; // as no smaller exist we can expand towards the right till the length of array
            int leftSmallerIndex = !st.isEmpty() ? st.peek() : -1;
            int area = element * (rightSmallerIndex - leftSmallerIndex - 1);
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }
}
