package org.example.week3_1;

// 문제 : https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
public class MinimumAbsoluteDifference {

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

    int minDifference = Integer.MAX_VALUE;
    Integer prev = null;
    public int solutionGetMinimumDifference(TreeNode root) {
        // 출처 : https://www.youtube.com/watch?v=uDykjVZ5s4o&ab_channel=AlgorithmsMadeEasy
        if (root == null) {
            return 0;
        }

        solutionGetMinimumDifference(root.left);

        if (prev != null) {
            minDifference = Math.min(minDifference, root.val-prev);
        }

        prev = root.val;

        solutionGetMinimumDifference(root.right);

        return minDifference;
    }
}
