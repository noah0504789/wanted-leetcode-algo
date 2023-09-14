package org.example.week1_1;

import java.util.Arrays;

// 문제링크 : https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {
    boolean[] canJump;

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        canJump = new boolean[nums.length];
        Arrays.fill(canJump, true);

        int start = nums[0];
        for (int i = start; i > 0; i--) {
            if (dfs(nums, i)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int[] nums, int idx) {
        if (idx >= nums.length-1) {
            return true;
        }

        int start = nums[idx], nextIdx;
        for (int i = start; i > 0; i--) {
            nextIdx = idx+i;
            if (nextIdx >= nums.length || !canJump[nextIdx]) {
                continue;
            }

            if (dfs(nums, nextIdx)) {
                return true;
            }

            canJump[nextIdx] = false;
        }

        return false;
    }

    // 출처 : https://www.youtube.com/watch?v=Zb4eRjuPHbM&ab_channel=NickWhite
    public boolean solutionCanJump(int[] nums) {
        int lastGoodIndexPosition = nums.length-1;
        for (int i = nums.length-1; i>=0; i--) {
            if (i + nums[i] >= lastGoodIndexPosition) {
                lastGoodIndexPosition = i;
            }
        }

        return lastGoodIndexPosition == 0;
    }
}
