package org.example.week2_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

// 출처 : https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150
public class EvaluateReversePolishNotation {
    public int myEvalRPN(String[] tokens) {
        Stack<Integer> right = new Stack<>();

        int first;
        int second;
        int result;

        int idx = 0;

        while (idx < tokens.length) {
            String token = tokens[idx];
            if (isOperator(token)) {
                second = right.pop();
                first = right.pop();
                result = calculate(first, second, token);

                right.push(result);
            } else {
                right.push(Integer.parseInt(token));
            }

            idx++;
        }

        return right.pop();
    }

    public int solutionEvalRPN(String[] tokens) {
        // 출처 : https://www.youtube.com/watch?v=iu0082c4HDE&ab_channel=NeetCode

        Stack<Integer> stack = new Stack<>();
        int right;
        int left;

        for (int i=0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                right = stack.pop();
                left = stack.pop();

                stack.push(left - right);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                right = stack.pop();
                left = stack.pop();

                stack.push(left / right);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }

        return false;
    }

    private int calculate(int first, int second, String operand) {
        return switch(operand) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }
}
