package com.johnnyjywuu.t81_100;

import com.johnnyjywuu.model.ListNode;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 92. 反转链表 II
 * @link https://leetcode-cn.com/problems/reverse-linked-list-ii
 * @description
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class T092_reverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) { //T25改一下
        if (head == null) return null;
        if (m == n) return head;

        ListNode preStart = new ListNode(0);
        preStart.next = head;
        ListNode start = head;

        for (int i = 1; i < m; i ++) { //移动结点至m起始点
            preStart = preStart.next;
            start = start.next;
        }

        ListNode end = start; //翻转后，start即为end
        //翻转链表
        ListNode preNode = null;
        for (int i = m; i <= n; i ++) {
            if (i == n) end.next = start.next; //当交换第n个结点时，把end.next指向该结点的next
            ListNode next = start.next;
            start.next = preNode;
            preNode = start;
            start = next;
        }
        preStart.next = preNode; //此时preNode移动到了第n个结点，翻转后preStart.next指向它

        return m == 1 ? preStart.next : head; //返回头结点，如果从第一个结点就开始翻转，不能返回head，因为head被翻转到后面去了
    }
}
