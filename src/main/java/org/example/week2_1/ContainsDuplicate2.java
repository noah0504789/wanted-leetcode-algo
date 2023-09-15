package org.example.week2_1;

import java.util.HashMap;
import java.util.Map;

// 문제링크 : https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
public class ContainsDuplicate2 {
    public boolean solutionContainsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
