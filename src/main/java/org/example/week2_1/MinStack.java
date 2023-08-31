package org.example.week2_1;

import java.util.Stack;

// 출처 : https://leetcode.com/problems/min-stack/description/?envType=study-plan-v2&envId=top-interview-150
public class MinStack {
    class MyMinStack {
        private int[] arr;
        private int[] min;
        private int top;

        MyMinStack() {
            arr = new int[30000];
            min = new int[30000];
            top = -1;
        }

        public void push(int val) {
            top++;
            arr[top] = val;
            min[top] = top == 0 ? val : Math.min(val, min[top-1]);
        }

        public void pop() {
            top--;
        }

        public int top() {
            return arr[top];
        }

        public int getMin() {
            return min[top];
        }
    }

    // 출처 : https://www.youtube.com/watch?v=WxCuL3jleUA&ab_channel=NickWhite
    class SolutionMinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        SolutionMinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int val) {
            if (min_stack.isEmpty() || min_stack.peek().intValue() >= val) {
                min_stack.push(val);
            }

            stack.push(val);
        }

        public void pop() {
            if (stack.peek().equals(min_stack.peek())) {
                min_stack.pop();
            }

            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
