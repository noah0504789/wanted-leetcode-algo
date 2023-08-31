package org.example.week1_2;

import java.util.HashSet;
import java.util.Set;

// 출처 : https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = myLengthOfLongestSubstring(s);
        solutionLengthOfLongestSubstring(s);
    }

    private static int solutionLengthOfLongestSubstring(String s) {
        // 출처 : https://www.youtube.com/watch?v=3IETreEybaA&ab_channel=NickWhite
        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> hashSet = new HashSet<>();

        while (j < s.length()) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                j++;
                max = Math.max(max, hashSet.size());
            } else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    public static int myLengthOfLongestSubstring(String s) {
        int ans=0;
        int left = 0;

        if (s.length() == 0) {
            return ans;
        }

        for (int right = 1; right < s.length(); right++) {
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == s.charAt(right)) {
                    left = i+1;
                    break;
                }
            }

            if (ans < right - left) {
                ans = right - left;
            }
        }

        return ans+1;
    }
}
