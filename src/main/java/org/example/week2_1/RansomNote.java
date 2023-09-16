package org.example.week2_1;

import java.util.HashMap;
import java.util.Map;

// 출처 : https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) == 0) {
                    return false;
                }

                map.put(c, map.get(c)-1);
            }
        }

        return true;
    }
}
