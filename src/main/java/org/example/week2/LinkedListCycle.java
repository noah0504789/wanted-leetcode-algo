package org.example.week2;

import java.util.HashSet;
import java.util.Set;

// 출처 : https://leetcode.com/problems/linked-list-cycle/submissions/?envType=study-plan-v2&envId=top-interview-150
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = null;
        myHasCycle(head);
        solutionHasCycle(head);
    }

    public static boolean myHasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> hashSet = new HashSet<>();

        while (head.next != null) {
            if (!hashSet.contains(head)) {
                hashSet.add(head);
            } else {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public static boolean solutionHasCycle(ListNode head) {
        // 출처 : https://www.youtube.com/watch?v=6OrZ4wAy4uE&ab_channel=NickWhite

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
