package org.example.week2;

// 출처 : https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;

        myAddTwoNumbers(l1, l2);
        solutionAddTwoNumbers(l1, l2);
    }

    public static ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
        int l1Val = 0;
        int l2Val = 0;
        int carry = 0;

        ListNode ans = new ListNode();
        ListNode head = ans;
        ListNode before = ans;
        ListNode tail = ans;

        while (l1 != null || l2 != null) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;

            ans.val = l1Val + l2Val + carry;

            if (ans.val >= 10) {
                ans.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ans.next = new ListNode();

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            before = ans;
            ans = ans.next;
            tail = ans;
        }

        if (carry == 1) {
            tail.val = carry;
        } else {
            before.next = null;
        }

        return head;
    }

    private static ListNode solutionAddTwoNumbers(ListNode l1, ListNode l2) {
        // 출처 : https://www.youtube.com/watch?v=aM4Iv7eEr2o&ab_channel=NickWhite
        ListNode dummy_head = new ListNode(0);
        ListNode l3 = dummy_head;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;

            int current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10;
            int last_digit = current_sum % 10;

            ListNode new_node = new ListNode(last_digit);
            l3.next = new_node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if (carry > 0) {
            ListNode new_node = new ListNode(carry);
            l3.next = new_node;
            l3 = l3.next;
        }

        return dummy_head.next;
    }
}
