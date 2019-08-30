package com.johnnyjywuu.model;

/**
 * @author Created by Johnny Wu on 2019/8/27.
 * @title 链表结点
 * @link
 * @description 一般链表结点
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return buildString(this);
    }

    public String buildString(ListNode node) {
        return node.next == null ? node.val + "" : node.val + ", " + buildString(node.next);
    }
}
