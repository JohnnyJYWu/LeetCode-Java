package com.johnnyjywuu.t81_100;

import com.johnnyjywuu.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title 94. 二叉树的中序遍历
 * @link https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * @description
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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

public class T094_inorderTraversal {
    //递归算法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            inorder(root, result);
        }

        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node.left != null) inorder(node.left, result); //左
        result.add(node.val); //中
        if (node.right != null) inorder(node.right, result); //右
    }

    //栈循环，非递归算法
    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }
}
