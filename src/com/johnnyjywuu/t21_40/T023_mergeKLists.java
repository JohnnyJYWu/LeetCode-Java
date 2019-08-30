package com.johnnyjywuu.t21_40;

import com.johnnyjywuu.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Created by Johnny Wu on 2019/8/28.
 * @title 23. 合并K个排序链表
 * @link https://leetcode-cn.com/problems/merge-k-sorted-lists
 * @description
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T023_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        //优先队列，根据Comparator自动排序
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val < node2.val) {
                    return -1;
                } else if (node1.val == node2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode head = new ListNode(0);
        ListNode node = head;
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            node.next = priorityQueue.poll();
            node = node.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return head.next;
    }
}
