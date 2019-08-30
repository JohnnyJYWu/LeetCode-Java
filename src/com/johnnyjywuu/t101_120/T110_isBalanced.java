package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 110. 平衡二叉树
 * @link https://leetcode-cn.com/problems/balanced-binary-tree
 * @description
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
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

public class T110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;

        int left = getDepth(root.left);
        if(left == -1) return -1;

        int right = getDepth(root.right);
        if(right == -1) return -1;

        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
