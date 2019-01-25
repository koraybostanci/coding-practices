package com.practicemakesperfect.leetcode;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example :
 *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   Output: 7 -> 0 -> 8
 *   Explanation: 342 + 465 = 807.
 *
 */
public class P02_AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int total = 0;
        int value = 0;
        int carry = 0;
        ListNode result = new ListNode(0);

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode c = result;
        while (c1 != null || c2 != null) {
            int x = c1 != null ? c1.val : 0;
            int y = c2 != null ? c2.val : 0;
            total = x + y + carry;

            carry = total / 10;
            value = total % 10;

            ListNode node = new ListNode(value);
            c.next = node;
            c = c.next;

            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            c.next = node;
        }

        return result.next;
    }

}
