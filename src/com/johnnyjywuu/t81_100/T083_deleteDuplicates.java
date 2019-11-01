package com.johnnyjywuu.t81_100;

import com.johnnyjywuu.model.ListNode;

/**
 * @author Created by Johnny Wu on 2019/9/3.
 * @title 83. 删除排序链表中的重复元素
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * @description
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T083_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;

        while (node != null && node.next != null) {
            if (node.next.val == node.val) { //比较当前结点和下一个结点的值，相同要删除下一个结点
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
