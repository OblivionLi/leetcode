package medium.stack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // push val into stack
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // removes from the top
    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    // get from top
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    // get min element
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "stack=" + stack +
                ", minStack=" + minStack +
                '}';
    }
}

public class MinStackMain {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(0);
        System.out.println("Before pop: " + minStack);
        minStack.push(-1);
        System.out.println("Before pop: " + minStack);
        minStack.push(2);
        System.out.println("Before pop: " + minStack);
        minStack.push(-88);
        System.out.println("Before pop: " + minStack);
        minStack.push(4);
        System.out.println("Before pop: " + minStack);
        minStack.push(-4);
        System.out.println("Before pop: " + minStack);
        minStack.push(100);
        System.out.println("Before pop: " + minStack);
        System.out.println("CHECK MIN: " + minStack.getMin()); // return -3
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println("After pop: " + minStack);
        System.out.println("CHECK STACK AFTER POP: " + minStack);
        System.out.println("TOP: " + minStack.top());    // return 0
        System.out.println("CHECK MIN: " + minStack.getMin()); // return -2
    }
}
