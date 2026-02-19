package com.dsaproblems.varsha.stacks;

import java.util.Scanner;

public class StackOperations {

    int[] arr;
    int top;

    StackOperations(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int val){
        if(top == arr.length-1){
           throw  new RuntimeException("Stack is full");
        }

        arr[++top] = val;
        System.out.println(val+" pushed in stack");
    }

    public int pop(){
        if(arr == null){
            throw  new RuntimeException("Stack is empty");
        }

        return arr[top--];
    }

    public int peek(){
        if(arr == null){
            throw  new RuntimeException("Stack is empty");
        }

        return arr[top];
    }




    public static void main(String[] args) {

        System.out.println("Enter the number of elements in the stack");
        int capacity = new Scanner(System.in).nextInt();

        StackOperations stack = new StackOperations(capacity);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop()+" popped from stack");
        System.out.println(stack.pop()+" popped from stack");

        System.out.println(stack.peek()+" is top element");



    }
}
