package org.example.week4_1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// 출처 : https://leetcode.com/problems/word-ladder/?envType=study-plan-v2&envId=top-interview-150
public class WordLadder {
    class Node {
        String word;
        int turn;

        Node (String word, int turn) {
            this.word = word;
            this.turn = turn;
        }
    }

    Set<String> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        visited = new HashSet<>(size);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String word = node.word;
            int turn = node.turn;

            if (word.equals(endWord)) {
                return turn;
            }

            for (String next : wordList) {
                if (isOneDiscrepency(word, next) && !visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new Node(next, turn+1));
                }
            }
        }

        return 0;
    }

    private boolean isOneDiscrepency(String word, String next) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != next.charAt(i)) count++;
            if (count > 1) return false;
        }

        return true;
    }
}
