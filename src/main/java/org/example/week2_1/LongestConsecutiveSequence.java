package org.example.week2_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // val - idx
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
        }

        int ans = 1, length;
        for (Integer num : map.keySet()) {
            length = 1;
            num = Integer.valueOf(num+1);
            while (map.containsKey(num) && !visited.contains(num)) {
                visited.add(num);
                num = Integer.valueOf(num+1);
                length++;
            }

            ans = Math.max(ans, length);
        }

        visited = new HashSet<>();
        for (Integer num : map.keySet()) {
            length = 1;
            num = Integer.valueOf(num-1);
            while (map.containsKey(num) && !visited.contains(num)) {
                visited.add(num);
                length++;
                num = Integer.valueOf(num-1);
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }

    // 출처 : https://www.youtube.com/watch?v=P6RZZMu_maU&ab_channel=NeetCode
    public int solutionLongestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num-1))  {
                int length = 0;
                while (set.contains(num + length)) {
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }

        return ans;
    }
}
