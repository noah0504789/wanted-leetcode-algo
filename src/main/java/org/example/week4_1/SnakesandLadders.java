package org.example.week4_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 문제 링크 : https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150
public class SnakesandLadders {

    // 출처 : https://github.com/ndesai15/coding-java/blob/master/src/com/coding/patterns/bfs/SnakesLadders.java
    class Pair {
        int square;
        int moves;

        public Pair(int square, int moves) {
            this.square = square;
            this.moves = moves;
        }
    }

    class PositionOnBoard {
        int r;
        int c;

        public PositionOnBoard(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Collections.reverse(Arrays.asList(board));

        Set<Integer> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int square = pair.square;
            int moves = pair.moves;

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square+i;
                PositionOnBoard newPosition = positionOnBoard(nextSquare, n);
                if (board[newPosition.r][newPosition.c] != -1) {
                    nextSquare = board[newPosition.r][newPosition.c];
                }

                if (nextSquare == n*n) {
                    return moves+1;
                }

                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.add(new Pair(nextSquare, moves+1));
                }
            }
        }

        return -1;
    }

    private PositionOnBoard positionOnBoard(int square, int n) {
        int r = (square-1)/n;
        int c = (square-1)%n;
        if (r%2 != 0) {
            c = n-1-c;
        }
        return new PositionOnBoard(r, c);
    }
}
