package org.example.week3_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// 문제링크 : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150

public class FindKPairswithSmallestSums {

    // 출처 : https://segmentfault.com/a/1190000008309330
    public List<List<Integer>> solutionKSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] {nums1[i], nums2[0], i, 0});
        }

        List<int[]> result = new ArrayList();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[2], j = cur[3];
            result.add(new int[] {cur[0], cur[1]});
            if (j+1 < nums2.length) {
                pq.offer(new int[] {nums1[i], nums2[j+1], i, j+1});
            }
        }

        return result.stream()
                .map(arr -> Arrays.stream(arr).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
