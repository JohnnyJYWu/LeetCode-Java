package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 104. 二叉树的最大深度
 * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * @description
 * 给定一个二叉树，找出其最大深度。x
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
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

public class T104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
