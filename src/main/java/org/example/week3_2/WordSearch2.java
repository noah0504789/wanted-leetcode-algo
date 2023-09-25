package org.example.week3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSearch2 {
    int r, c, wordIdx;
    char ch1;
    int[] dy, dx;
    Set<String> answer;
    public List<String> findWords(char[][] board, String[] words) {
        r = board.length;
        c = board[0].length;
        dy = new int[] {1, 0, -1, 0};
        dx = new int[] {0, 1, 0, -1};
        answer = new HashSet<>();

        for (String word : words) {
            if (word.length() > r*c) {
                continue;
            }
            wordIdx = 0;
            ch1 = word.charAt(wordIdx);

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == ch1) {
                        boolean[][] visited = new boolean[r][c];
                        dfs(i, j, board, wordIdx, word, visited);
                    }
                }
            }
        }

        return answer.stream().collect(Collectors.toList());
    }

    private boolean dfs(int y, int x, char[][] board, int idx, String word, boolean[][] visited) {
        if (!validate(y, x, board, idx, word, visited)) {
            return false;
        }

        if (idx == word.length()-1) {
            answer.add(word);
            return true;
        }

        visited[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            int ni = idx + 1;

            if (dfs(ny, nx, board, ni, word, visited)) {
                return true;
            }
        }

        visited[y][x] = false;

        return false;
    }

    private boolean validate(int y, int x, char[][] board, int idx, String word, boolean[][] visited) {
        if (y < 0 || y > r-1 || x < 0 || x > c-1) {
            return false;
        }

        if (visited[y][x]) {
            return false;
        }

        if (board[y][x] != word.charAt(idx)) {
            return false;
        }

        return true;
    }

    // 출처 : https://www.youtube.com/watch?v=IryjR5DteW4&ab_channel=EricProgramming
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean isWord;

        TrieNode() {
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }
    TrieNode trie;
    List<String> res;
    int m, n;
    char[][] board;
    boolean[][] visited;
    public List<String> solutionFindWords(char[][] board, String[] words) {
        trie = new TrieNode();
        res = new ArrayList<>();
        this.board = board;
        m = board.length;
        n = board[0].length;
        for (String word : words) {
            insertAWord(word);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char curC = board[r][c];
                visited = new boolean[m][n];
                dfs(r, c, new StringBuilder(), trie);
            }
        }

        return res;
    }

    private void insertAWord(String word) {
        char[] cArr = word.toCharArray();
        TrieNode curNode = trie;
        for (char curC : cArr) {
            if (!curNode.map.containsKey(curC)) {
                curNode.map.put(curC, new TrieNode());
            }
            curNode = curNode.map.get(curC);
        }
        curNode.isWord = true;
    }

    private void dfs(int r, int c, StringBuilder sb, TrieNode curTrie) {
        if (r < 0 || r == m || c < 0 || c == n) return;
        if (visited[r][c]) return;
        char curC = board[r][c];
        if (!curTrie.map.containsKey(curC)) return;
        sb.append(curC);
        curTrie = curTrie.map.get(curC);
        visited[r][c] = true;

        if (curTrie.isWord) {
            res.add(sb.toString());
            curTrie.isWord = false;
        }

        dfs(r, c+1, sb, curTrie);
        dfs(r, c-1, sb, curTrie);
        dfs(r+1, c, sb, curTrie);
        dfs(r-1, c, sb, curTrie);

        sb.setLength(sb.length()-1);
        visited[r][c] = false;
    }
}
