package org.example.week2_1;

import java.util.HashMap;
import java.util.Map;

// 문제 링크 : https://leetcode.com/problems/word-pattern/submissions/?envType=study-plan-v2&envId=top-interview-150
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");

        if (s1.length != pattern.length()) {
            return false;
        }

        Map<Character, String> pTos = new HashMap<>();
        Map<String, Character> sTop = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            if (pTos.containsKey(p)) {
                if (!pTos.get(p).equals(s1[i])) {
                    return false;
                }
            } else {
                pTos.put(p, s1[i]);
            }

            String s_ = s1[i];
            if (sTop.containsKey(s_)) {
                if (!sTop.get(s_).equals(p)) {
                    return false;
                }
            } else {
                sTop.put(s_, p);
            }
        }

        return true;
    }
}
