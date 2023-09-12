package org.example.week1_1;

// 문제링크 : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        int i = 0, left = 0, right = 1, tmp;
        int lVal, rVal;
        while (left < nums.length) {
            lVal = nums[left];
            if (left == nums.length-1) {
                nums[i] = lVal;
                ans++;
                break;
            }

            rVal = nums[right];

            if (lVal == rVal) {
                tmp = right+1;
                while (tmp < nums.length && rVal == nums[tmp]) {
                    tmp++;
                }

                left = tmp;
                right = tmp+1;

                nums[i] = lVal;
                nums[i+1] = rVal;

                i += 2;
                ans += 2;
            } else {
                nums[i] = lVal;

                left++;
                right++;
                i++;
                ans++;
            }
        }

        return ans;
    }
}
