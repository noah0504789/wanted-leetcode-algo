package org.example.week2_1;

import java.util.HashMap;
import java.util.Map;

// 문제 링크 : https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (!mapS.containsKey(sc)) {
                mapS.put(sc, tc);
            } else {
                if (!mapS.get(sc).equals(tc)) {
                    return false;
                }
            }

            if (!mapT.containsKey(tc)) {
                mapT.put(tc, sc);
            } else {
                if (!mapT.get(tc).equals(sc)) {
                    return false;
                }
            }
        }

        return true;
    }
}
