package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

/**
 * @author Created by Johnny Wu on 2019/11/1.
 * @title 114. 二叉树展开为链表
 * @link https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * @description
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

public class T114_flatten {
    private TreeNode pre = null;

    public void flatten(TreeNode root) { //递归
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
