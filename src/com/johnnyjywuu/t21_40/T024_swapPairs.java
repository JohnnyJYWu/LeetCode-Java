package com.johnnyjywuu.t21_40;

/**
 * @author Created by Johnny Wu on 2019/8/23.
 * @title 24. 两两交换链表中的节点
 * @link https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * @description
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T024_swapPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;// 判空

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);// 翻转，第一个的next指向第二个的next，同时第二个的next调用此方法递归执行，对后面的链表进行翻转
        second.next = first;// 翻转，第二个的next指向第一个

        return second;
    }
}
