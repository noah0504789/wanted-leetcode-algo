package org.example.week1;

// 문제 : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int answer = myRemoveDuplicates(nums);
        solutionRemoveDuplicates(nums);
    }

    private static int myRemoveDuplicates(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[++count] = nums[i+1];
            }
        }

        return count + 1;
    }

    // https://bcp0109.tistory.com/260
    private static int solutionRemoveDuplicates(int[] nums) {
        int index = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[index++] = nums[i+1];
            }
        }

        return index;
    }
}
