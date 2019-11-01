package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

import java.util.*;

/**
 * @author Created by Johnny Wu on 2019/9/2.
 * @title 107. 二叉树的层次遍历 II
 * @link https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * @description
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class T107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) { //同T102
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue1 = new LinkedList<>(); //广度优先搜索，辅助队列1
        Queue<TreeNode> queue2 = new LinkedList<>(); //广度优先搜索，辅助队列2

        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.poll();
                    list.add(node.val);
                    if (node.left != null) queue2.offer(node.left);
                    if (node.right != null) queue2.offer(node.right);
                }
                result.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.poll();
                    list.add(node.val);
                    if (node.left != null) queue1.offer(node.left);
                    if (node.right != null) queue1.offer(node.right);
                }
                result.add(list);
            }
        }
        //T102结果翻转一下就好
        Collections.reverse(result);

        return result;
    }
}
