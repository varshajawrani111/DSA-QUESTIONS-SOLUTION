package com.dsaproblems.varsha.stacks;

public class MinStack {

    static class StackOperations {

        int[] arr;
        int top;

        StackOperations(int size) {
            arr = new int[size];
            top = -1;
        }

        public void push(int val) {
            if (top == arr.length - 1) {
                throw new RuntimeException("Stack is full");
            }
            arr[++top] = val;
        }

        public int pop() {
            if (top == -1) {
                throw new RuntimeException("Stack is empty");
            }
            return arr[top--];
        }

        public int peek() {
            if (top == -1) {
                throw new RuntimeException("Stack is empty");
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    private  StackOperations mainStack;
    private  StackOperations minStack;

    MinStack(int capacity) {
        mainStack = new StackOperations(capacity);
        minStack = new StackOperations(capacity);
    }

    //push operation for minstacks
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()) { //push only when stack is empty or the new value is less the top element on the stack
            minStack.push(val);
        }
    }

    //pop operation for min stack
    public int pop() {

        int removed = mainStack.pop();

        if(removed == minStack.peek()) {  //if the minimum element s popped from the mainstack it should also get popped from minStack
            minStack.pop();
        }

        return removed;
    }

    //peek operation
    public int peek() {
        return mainStack.peek();
    }

    //getMin() to get the minimum element from the stack
    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {

        MinStack st = new MinStack(10);

        st.push(5);
        st.push(3);
        st.push(7);
        st.push(3);

        System.out.println(st.getMin()); // 3
        st.pop();                        // removes 3
        System.out.println(st.getMin()); // 3
        st.pop();                        // removes 7
        System.out.println(st.getMin()); // 3
        st.pop();                        // removes 3
        System.out.println(st.getMin()); // 5
    }
}
