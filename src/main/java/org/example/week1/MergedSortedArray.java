package org.example.week1;

//  https://leetcode.com/problems/merge-sorted-array/description/
public class MergedSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;

        myMerge(nums1, m, nums2, n); // O((m+n)^2)
        solutionMerge(nums1, m, nums2, n); // O(m+n)
        for (int num : nums1){
            System.out.println(num);
        }
    }

    public static void myMerge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int totCnt = m+n;
        int mCnt = 0;
        int nCnt = 0;
        int pointer = 0;

        while (pointer < totCnt && mCnt < m && nCnt < n) {
            if (nums1[pointer] > nums2[nCnt]) {
                for (int i = totCnt-1; i > pointer; i--) {
                    nums1[i] = nums1[i-1];
                }

                nums1[pointer] = nums2[nCnt++];
            } else {
                mCnt++;
            }

            pointer++;
        }

        if (nCnt < n) {
            for (int i = nCnt; i < n; i++) {
                nums1[pointer++] = nums2[i];
            }
        }
    }

    private static void solutionMerge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m+n-1;
        int mPointer = m-1;
        int nPointer = n-1;

        while (pointer >= 0 && mPointer >= 0 && nPointer >= 0) {
            if (nums1[mPointer] > nums2[nPointer]) {
                nums1[pointer--] = nums1[mPointer--];
            } else {
                nums1[pointer--] = nums2[nPointer--];
            }
        }

        while (nPointer >= 0) {
            nums1[pointer--] = nums2[nPointer--];
        }
    }
}
