package org.example.week3_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 출처 : https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-interview-150
public class BinaryTreeRightSideView {

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

    public List<Integer> solutionRightSideView(TreeNode root) {
        // 출처 : https://www.youtube.com/watch?v=xyHb_ghpXf4&ab_channel=NickWhite
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return answer;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == 0) answer.add(currentNode.val);
                if (currentNode.right != null) queue.offer(currentNode.right);
                if (currentNode.left != null) queue.offer(currentNode.left);
            }
        }

        return answer;
    }
}
