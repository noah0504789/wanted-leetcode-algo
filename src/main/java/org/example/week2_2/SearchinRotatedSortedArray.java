package org.example.week2_2;

// 문제링크 : https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }

        int length = nums.length;
        int left = 0, right = length-1;

        while (left <= right) {
            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            left++;
            right--;
        }

        return -1;
    }

    // 출처 : chatgpt
    public int solutionSearch(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }

        int length = nums.length;
        int left = 0, right = length-1;

        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { //
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
