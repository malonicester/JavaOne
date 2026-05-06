package org.java.stacks;

import org.java.graph.Pair;

import java.util.Stack;

public class MinStackSpaceOptimized {

    private final Stack<Pair<Integer, Integer>> st = new Stack<>();

    public static void main(String[] args) {
        MinStackSpaceOptimized minStack = new MinStackSpaceOptimized();
        minStack.push(17);
        minStack.push(18);
        minStack.push(25);
        minStack.push(24);
        minStack.push(23);
        minStack.push(16);
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
        minStack.push(1);
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair<>(val, val));
            return;
        }

        Pair<Integer, Integer> peek = st.peek();
        if (val < peek.value) {
            st.push(new Pair<>(val, val));
        } else {
            st.push(new Pair<>(val, peek.value));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return !st.isEmpty() ? st.peek().key : -1;
    }

    public int getMin() {
        return !st.isEmpty() ? st.peek().value : -1;
    }
}
