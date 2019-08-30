package com.johnnyjywuu.model;

/**
 * @author Created by Johnny Wu on 2019/8/27.
 * @title 双向链表结点
 * @link
 * @description 一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
