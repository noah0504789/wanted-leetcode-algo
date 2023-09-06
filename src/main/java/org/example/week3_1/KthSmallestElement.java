package org.example.week3_1;

import java.util.Stack;

public class KthSmallestElement {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count = 0;
    public int myKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int temp = myKthSmallest(root.left, k);

        if (temp != Integer.MAX_VALUE) {
            return temp;
        }

        count++;
        if (count == k) {
            return root.val;
        }

        return myKthSmallest(root.right, k);
    }

    public int solutionKthSmallest(TreeNode root, int k) {
        // 출처 : https://www.youtube.com/watch?v=5LUXSvjmGCw&ab_channel=NeetCode

        int n = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            n+=1;
            if (n == k) {
                return cur.val;
            }

            cur = cur.right;
        }

        return 0;
    }
}
