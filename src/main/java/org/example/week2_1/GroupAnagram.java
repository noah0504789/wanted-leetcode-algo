package org.example.week2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 문제 링크 : https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return List.of(List.of(strs));
        }

        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String strKey = ascending(str);
            List<String> strValue;

            if (map.containsKey(strKey)) {
                strValue = map.get(strKey);
                strValue.add(str);
            } else {
                strValue = new ArrayList<>();
                strValue.add(str);
                map.put(strKey, strValue);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    private String ascending(String key) {
        char[] keyArr = key.toCharArray();
        Arrays.sort(keyArr);

        StringBuffer newKey = new StringBuffer();
        for (char c : keyArr) {
            newKey.append(c);
        }

        return newKey.toString();
    }

    // 출처 : https://www.youtube.com/watch?v=vzdNOK2oB2E&ab_channel=NeetCode
    class AnagramKey {
        public Integer[] visited;

        public AnagramKey(String key) {
            this.visited = new Integer[26];
            fill(key);
        }

        public int hashCode() {
            int result = 17;
            for (int i = 0; i < visited.length; i++) {
                result += 31 * visited[i];
            }

            return result;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }

            AnagramKey other = (AnagramKey) obj;
            for (int i = 0; i < visited.length; i++) {
                if (!this.visited[i].equals(other.visited[i])) {
                    return false;
                }
            }

            return true;
        }

        private void fill(String key) {
            Arrays.fill(this.visited, 0);

            for (char c : key.toCharArray()) {
                int idx = c - 'a';
                this.visited[idx] += 1;
            }
        }
    }

    public List<List<String>> solutionGroupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return List.of(List.of(strs));
        }

        List<List<String>> ans = new ArrayList<>();
        Map<AnagramKey, List<String>> map = new HashMap<>();

        for (String str : strs) {
            AnagramKey strKey = new AnagramKey(str);
            List<String> strValue;

            if (map.containsKey(strKey)) {
                strValue = map.get(strKey);
                strValue.add(str);
            } else {
                strValue = new ArrayList<>();
                strValue.add(str);
                map.put(strKey, strValue);
            }
        }

        for (Map.Entry<AnagramKey, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
