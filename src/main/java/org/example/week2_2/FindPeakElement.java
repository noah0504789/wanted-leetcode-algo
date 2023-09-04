package org.example.week2_2;

// 문제 : https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (right > left) {
            mid = (right + left)/2 + 1;
            if (nums[mid] > nums[mid-1]) {
                left = mid;
            } else {
                right = mid-1;
            }
        }

        return right;
    }
}
