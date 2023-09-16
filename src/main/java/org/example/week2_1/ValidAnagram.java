package org.example.week2_1;

import java.util.HashMap;
import java.util.Map;

// 문제 링크 : https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) == 0) {
                    return false;
                }

                map.put(c, map.get(c)-1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
