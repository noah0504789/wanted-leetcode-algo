package org.example.week1_1;

// 문제링크 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0, minDay = 0, maxDay = prices.length-1, prev = prices[0];
        boolean isDesc = true;

        for (int i = 1; i < prices.length; i++) {
            if (prev < prices[i] && isDesc) {
                isDesc = false;
            }

            prev = prices[i];

            if (min > prices[i] && i < maxDay) { // buy
                min = prices[i];
                minDay = i;
            }

            if (max < prices[i] && i > minDay) { // sell
                max = prices[i];
                maxDay = i;
            }
        }

        System.out.println(min);
        System.out.println(max);

        return isDesc ? 0 : max-min;
    }

    // 출처 : https://www.youtube.com/watch?v=3RHCb8LY-X4&ab_channel=NickWhite
    public int solutionMaxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i <prices.length; i++) {
            if (prices[i] < min_val) {
                min_val = prices[i];
            } else if (prices[i] - min_val > max_profit) {
                max_profit = prices[i] - min_val;
            }
        }

        return max_profit;
    }
}
