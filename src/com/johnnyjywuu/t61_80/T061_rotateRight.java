package com.johnnyjywuu.t61_80;

import com.johnnyjywuu.model.ListNode;

/**
 * @author Created by Johnny Wu on 2019/9/3.
 * @title 61. 旋转链表
 * @link https://leetcode-cn.com/problems/rotate-list
 * @description
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */

public class T061_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) return head;

        //链表首尾相连，成环形
        ListNode temp = head;
        int num = 1; //记录结点数量
        while (temp.next != null) {
            num ++;
            temp = temp.next;
        }
        temp.next = head;

        ListNode node = head;

        for (int i = 0; i < num - (k % num) - 1; i ++) { //向右移动k个结点相当于想左移动num - (k % num)个结点，-1是为了让node指向新的末尾，少移动一步
            node = node.next;
        }
        //此时node指向新的末尾，node.next为新的头
        ListNode newHead = node.next;
        node.next = null;

        return newHead;
    }
}
