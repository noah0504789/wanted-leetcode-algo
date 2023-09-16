package org.example.week2_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 문제 링크 : https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150
public class HappyNumber {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean isHappy(int n) {
        while (n != 1 && !map.containsKey(n)) {
            n = process(n);
        }

        return n == 1 ? true : false;
    }

    private int process(int n) {
        int key = n;
        int num, sum = 0;
        while (n > 0) {
            num = n % 10;
            sum += num * num;
            n /= 10;
        }

        map.put(Integer.valueOf(key), sum);

        return sum;
    }

    // 출처 : https://www.youtube.com/watch?v=ljz85bxOYJ0&ab_channel=NeetCode
    public boolean solutionIsHappy(int n) {
        while (n != 1 && !visited.contains(n)) {
            n = solutionProcess(n);
        }

        return n == 1 ? true : false;
    }

    private int solutionProcess(int n) {
        visited.add(n);

        int num, sum = 0;
        while (n > 0) {
            num = n % 10;
            sum += num * num;
            n /= 10;
        }

        return sum;
    }
}
