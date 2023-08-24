package org.example.week1;

// 문제 : https://leetcode.com/problems/remove-element/
public class RemoteElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;

        int k = 0;
        k = myRemoveElement(nums, val);
        k = solutionRemoveElement(nums, val);
    }

    public static int myRemoveElement(int[] nums, int val) {
        int length = nums.length;
        int searchIdx = length - 1;
        int offset = 0;
        int sourceIdx = 0;
        int targetIdx = 0;
        int source = 0;

        while (searchIdx >= 0) {
            int curNum = nums[searchIdx];

            if (curNum == val) {
                nums[searchIdx] = '_';

                sourceIdx = searchIdx;
                targetIdx =             length-1-offset;
                nums[sourceIdx] = nums[targetIdx];

                source = nums[sourceIdx];
                nums[targetIdx] = source;

                offset++;
            }

            searchIdx--;
        }

        return length - offset;
    }

    // 출처 : https://bcp0109.tistory.com/172
    private static int solutionRemoveElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
