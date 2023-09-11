package org.example.week3_2;

// 문제링크 : https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure {

    class Node {
        private Map<Character, Node> children;
        private boolean endOfWord;

        Node () {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }

    private Node root;

    public DesignAddandSearchWordsDataStructure() {
        this.root = new Node();
    }

    public void addWord(String word) {
        this.addWord(this.root, word);
    }

    private void addWord(Node node, String word) {
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

        addWord(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(Node node, String word) {
        if (word.length() == 0) {
            return node.endOfWord;
        }

        char c = word.charAt(0);
        Node child = null;
        if (c == '.') {
            if (node.children.size() == 0) {
                return false;
            }

            List<Boolean> tmp = new ArrayList<>();
            for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
                tmp.add(search(entry.getValue(), word.substring(1)));
            }

            return !tmp.stream().allMatch(b -> b == false);
        }

        child = node.children.get(c);
        if (child == null) {
            return false;
        }

        return search(child, word.substring(1));
    }
}
