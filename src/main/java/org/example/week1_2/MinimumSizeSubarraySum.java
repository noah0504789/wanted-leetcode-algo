package org.example.week1_2;

// 출처 : https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};

        failMinSubArrayLen(target, nums); // time limit exceeded O(n^2)
        neetCodeMinSubArrayLen(target, nums);
    }

    private static int failMinSubArrayLen(int target, int[] nums) {
        int[] curSubElemArr = nums.clone();
        int curSubElemCount = 1;

        while (curSubElemCount <= nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (curSubElemArr[i] >= target) {
                    return curSubElemCount;
                }

                if (i < nums.length-curSubElemCount) {
                    curSubElemArr[i] += nums[i+curSubElemCount];
                }
            }

            curSubElemCount++;
        }

        return 0;
    }

    public static int neetCodeMinSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int subSum = nums[0];
        int ans = nums.length+1;

        while (left <= right && right < nums.length) {
            if (subSum >= target) {
                if (ans > right-left) {
                    ans = right-left;
                }

                subSum -= nums[left++];
            } else {
                if (right == nums.length-1) break;
                subSum += nums[++right];
            }
        }

        return ans == nums.length+1 ? 0 : ans+1;
    }
}
