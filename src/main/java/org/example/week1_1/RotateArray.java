package org.example.week1_1;

// 문제링크 : https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        if (k == 0 || nums.length == 1) {
            return;
        }

        int[] tmpArr = new int[nums.length-k];

        int cnt = 0;
        for (int i = 0; i < nums.length-k; i++) {
            tmpArr[cnt++] = nums[i];
        }

        cnt = 0;
        for (int i = nums.length-k; i < nums.length; i++) {
            nums[cnt++] = nums[i];
        }

        int cnt2 = 0;
        for (int i = cnt; i < nums.length; i++) {
            nums[i] = tmpArr[cnt2++];
        }
    }

    // 출처 : https://www.youtube.com/watch?v=gmu0RA5_zxs&ab_channel=NickWhite
    public void solutionRotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
