package com.johnnyjywuu.t0_20;

import com.johnnyjywuu.model.ListNode;

/**
 * @author Created by Johnny Wu on 2019/8/27.
 * @title 19. 删除链表的倒数第N个节点
 * @link https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * @description
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T019_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = new ListNode(0); //创造head的前一个结点，双指针由前一个结点开始遍历，寻找倒数第n-1个结点
        preNode.next = head;

        ListNode node1 = preNode;
        ListNode node2 = preNode;

        for (int i = 0; i <= n; i ++) {
            node1 = node1.next;
        }

        while(node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        node2.next = node2.next.next;

        return preNode.next; //这里不能返回head，因为有可能head本身就是要删掉的结点
    }

    public ListNode removeNthFromEndOld(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null && n == 1) return null; //只有1个结点是时直接返回null

        ListNode node1 = head;
        ListNode node2 = head;
        ListNode pre = null; //记录倒数第k个结点的前一个结点

        while(node1 != null && n > 0) { //node1移动k次，还有n-k次会指空
            node1 = node1.next;
            n --;
        }

        if(n > 0) return null;

        while(node1 != null) { //移动n-k次，此时node2到n-k+1个结点，即倒数第k个结点
            node1 = node1.next;
            pre = node2;
            node2 = node2.next;
        }

        if (pre == null) { //说明需要去掉的是第1个结点
            head = head.next;
        } else {
            pre.next = node2.next;
        }

        return head;
    }
}
