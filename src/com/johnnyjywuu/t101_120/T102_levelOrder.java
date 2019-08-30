package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 102. 二叉树的层次遍历
 * @link https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * @description
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class T102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
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

        return result;
    }
}
