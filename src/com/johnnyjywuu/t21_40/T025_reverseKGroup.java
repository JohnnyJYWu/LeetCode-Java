package com.johnnyjywuu.t21_40;

import com.johnnyjywuu.model.ListNode;

import java.util.Stack;

/**
 * @author Created by Johnny Wu on 2019/8/28.
 * @title 25. K 个一组翻转链表
 * @link https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * @description
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T025_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0 || k == 1) return head;

        ListNode nextHead = head;
        for (int i = 0; i < k; i ++) {
            if (nextHead == null) { //最后剩余的节点保持原有顺序
                return head;
            }
            nextHead = nextHead.next;
        }

        ListNode end = head; //翻转后，head即为end
        //翻转链表
        ListNode preNode = null;
        for (int i = 0; i < k; i ++) {
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }

        end.next = reverseKGroup(nextHead, k); //递归后面的链表

        return preNode;
    }

    //栈，耗时太长
    public ListNode reverseKGroupStack(ListNode head, int k) {
        if (head == null || k == 0 || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            ListNode preStart = node;
            for (int i = 0; i < k; i ++) {
                node = node.next;
                if (node == null) {
                    return dummy.next;
                }
                stack.push(node);
            }
            ListNode sufEnd = node.next;
            while (!stack.isEmpty()) {
                preStart.next = stack.pop();
                preStart = preStart.next;
            }
            preStart.next = sufEnd;
            node = preStart;
        }

        return dummy.next;
    }
}
