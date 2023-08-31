package org.example.week2_1;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
public class TwoSum {
    public int[] myTwoSum(int[] nums, int target) {
         for (int i = 0; i < nums.length; i++) {
             for (int j = i+1; j < nums.length; j++) {
                 if (nums[i] + nums[j] == target) {
                     return new int[]{i, j};
                 }
             }
         }

         return null;
    }

    public int[] solutionTwoSum(int[] nums, int target) {
        // 출처 : https://www.youtube.com/watch?v=KLlXCFG5TnA&ab_channel=NeetCode

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(target-num) && hashMap.get(target-num) != i) {
                return new int[]{hashMap.get(target-num), i};
            }
        }

        return null;
    }
}
