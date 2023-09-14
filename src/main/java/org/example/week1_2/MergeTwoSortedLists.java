package org.example.week1_2;

// 문제링크 : https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode tmp = ans;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tmp.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            tmp = tmp.next;
        }

        if (list1 != null) {
            tmp.next = list1;
        }

        if (list2 != null) {
            tmp.next = list2;
        }

        return ans.next;
   }
}
