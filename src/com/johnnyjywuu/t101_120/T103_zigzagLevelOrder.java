package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 103. 二叉树的锯齿形层次遍历
 * @link https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * @description
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
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

public class T103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack1 = new Stack<>(); //广度优先搜索，辅助栈1
        Stack<TreeNode> stack2 = new Stack<>(); //广度优先搜索，辅助栈2

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                result.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    //栈2相当于偶数层从右往左遍历，其子树加入栈1的顺序是相反的，先右后左
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                result.add(list);
            }
        }

        return result;
    }
}
