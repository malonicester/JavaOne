package org.java.stacks;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> elementStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
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
        minStack.pop();System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
        System.out.println("Minimum Value is " + minStack.getMin());
        System.out.println("Top Value is " + minStack.top());
        minStack.pop();
    }

    public void push(int val) {
        elementStack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val) minStack.push(val);
    }

    public void pop() {
        Integer element = elementStack.pop();
        if(element.equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return  !elementStack.isEmpty() ? elementStack.peek() : -1;
    }

    public int getMin() {
        return !minStack.isEmpty() ? minStack.peek() : -1;
    }
}
