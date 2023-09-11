package org.example.week3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 문제링크 : https://leetcode.com/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=top-interview-150
class ImplementTrie {

    class Node {
        private Map<Character, Node> children;
        private boolean endOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }

    private Node root;

    public ImplementTrie() {
        this.root = new Node();
    }

    public void insert(String word) {
        insert(this.root, word);
    }

    private void insert(Node node, String word) {
        if (word.length() == 0) {
            node.endOfWord = true;
            return;
        }

        char c = word.charAt(0);
        Node child = node.children.get(c);
        if (child == null) {
            child = new Node();
            node.children.put(c, child);
        }

        insert(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(Node node, String word) {
        if (word.length() == 0) {
            return node.endOfWord;
        }

        char c = word.charAt(0);
        Node child = node.children.get(c);
        if (child == null) {
            return false;
        }

        return search(child, word.substring(1));
    }

    public boolean startsWith(String prefix) {
        Node cur = this.root, child;

        for (char c : prefix.toCharArray()) {
            child = cur.children.get(c);

            if (child == null) {
                return false;
            }

            cur = child;
        }

        if (cur.children.isEmpty()) {
            return true;
        }

        return startsWith(cur).stream().anyMatch(b -> b == true);
    }

    private List<Boolean> startsWith(Node node) {
        List<Boolean> answer = new ArrayList<>();

        Node child;
        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            child = entry.getValue();
            if (child.endOfWord) {
                answer.add(true);
                return answer;
            } else {
                answer.addAll(startsWith(child));
            }
        }

        return answer;
    }
}
