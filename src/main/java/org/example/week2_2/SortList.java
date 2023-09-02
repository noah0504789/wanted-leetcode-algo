package org.example.week2_2;

// 출처 : https://leetcode.com/problems/sort-list/
public class SortList {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mySortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);

        ListNode left = mySortList(head);
        ListNode right = mySortList(mid);

        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        temp = head;
        ListNode before = head;
        count = (count/2) + (count%2);
        while (count > 0) {
            before = temp;
            temp = temp.next;
            count--;
        }

        before.next = null;

        return temp;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                dummy.next = new ListNode(a.val);
                a = a.next;
            } else if (b.val < a.val) {
                dummy.next = new ListNode(b.val);
                b = b.next;
            } else {
                dummy.next = new ListNode(a.val, new ListNode(a.val));
                dummy = dummy.next;
                a = a.next;
                b = b.next;
            }

            dummy = dummy.next;
        }

        if (a != null) {
            dummy.next = a;
        }

        if (b != null) {
            dummy.next = b;
        }

        return current.next;
    }
}



