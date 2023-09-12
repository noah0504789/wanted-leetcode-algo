package org.example.week1_1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 문제링크 : https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList())) {
            return entry.getKey();
        }

        return 0;
    }

    // 출처 : https://doozi0316.tistory.com/entry/leetCode-169-Majority-Element-Easy-%ED%92%80%EC%9D%B4
    public int solutionMajorityElement(int[] nums) {
        int count = 1, major = nums[0], limitCnt = nums.length/2;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }

            if (count > limitCnt) return nums[i];
        }

        return major;
    }
}
