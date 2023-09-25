package org.example.week2_2;

// 문제링크 : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return nums[0] < nums[1] ? nums[0] : nums[1];
        }

        int length = nums.length;
        int left = 0, right = length-1, mid = 0;
        if (nums[left] < nums[right]) {
            return nums[0];
        }

        while (left <= right) {
            mid = (left + right)/2;
            if (mid == 0) {
                mid = nums[0] < nums[1] ? 0 : 1;
                break;
            }

            if (mid == length-1) {
                mid = nums[length-1] < nums[length-2] ? length-1 : length-2;
                break;
            }

            if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
                break;
            }

            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                mid += 1;
                break;
            }

            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[mid];
    }

    // 출처 : https://www.youtube.com/watch?v=IzHR_U8Ly6c&ab_channel=NickWhite
    public int solutionFindMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}
