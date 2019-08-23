package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/13.
 * @title 2. 两数相加
 * @link https://leetcode-cn.com/problems/add-two-numbers/
 * @description
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T002_addTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        boolean isCarry = false;// 是否进位

        ListNode head = result;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (isCarry ? 1 : 0);// （三元表达式）上一位进位则+1，否则+0
            if (isCarry) isCarry = false;// 进位了则充值isCarry为false

            if (sum >= 10) {// 相加>10进位
                sum -= 10;
                isCarry = true;
            }
            head.next = new ListNode(sum);
            // 链表指针后移
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        // l1有剩余高位数未加完，继续加进去
        while (l1 != null) {
            int sum = l1.val;
            if (isCarry) {
                sum ++;
                isCarry = false;
            }
            if (sum >= 10) {
                sum -= 10;
                isCarry = true;
            }
            head.next = new ListNode(sum);
            l1 = l1.next;
            head = head.next;
        }
        // l2有剩余高位数未加完，继续加进去
        while (l2 != null) {
            int sum = l2.val;
            if (isCarry) {
                sum ++;
                isCarry = false;
            }
            if (sum >= 10) {
                sum -= 10;
                isCarry = true;
            }
            head.next = new ListNode(sum);
            l2 = l2.next;
            head = head.next;
        }
        // 若此时isCarry仍为true需要进位，则进1
        if (isCarry) {
            head.next = new ListNode(1);
        }

        return result.next;
    }
}
