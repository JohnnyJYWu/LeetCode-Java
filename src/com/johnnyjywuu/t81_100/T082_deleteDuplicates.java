package com.johnnyjywuu.t81_100;

import com.johnnyjywuu.model.ListNode;

/**
 * @author Created by Johnny Wu on 2019/9/3.
 * @title 82. 删除排序链表中的重复元素 II
 * @link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * @description
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T082_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = new ListNode(Integer.MIN_VALUE); //定义虚拟头结点
        preNode.next = head;
        ListNode node = preNode;

        while (node.next != null && node.next.next != null) {
            if (node.next.next.val == node.next.val) { //比较后两个的值，相同则需把同志结点全部删除
                int delVal = node.next.val;
                while (node.next != null && node.next.val == delVal) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }
        //由于head结点可能重复导致需要被删除，因此返回preNode.next
        return preNode.next;
    }
}
