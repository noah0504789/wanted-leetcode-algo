package org.example.week1_1;

// 문제링크 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimetoBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curIdx = prices.length-1, prevIdx = curIdx-1;

        while (curIdx > 0) {
            if (prices[curIdx] > prices[prevIdx]) {
                while (prevIdx > 0 && prices[prevIdx] > prices[prevIdx-1]) {
                    prevIdx--;
                }
                maxProfit += prices[curIdx] - prices[prevIdx];
            }

            curIdx = prevIdx;
            prevIdx = curIdx-1;
        }

        return maxProfit;
    }
}
