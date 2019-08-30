package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 101. 对称二叉树
 * @link https://leetcode-cn.com/problems/symmetric-tree
 * @description
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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

public class T101_isSymmetric {
    //递归算法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; //左右皆空，对称
        if (left == null || right == null) return false; //左右一个空，不对称

        return left.val == right.val //对称必要条件：值相等
                && isSymmetricTree(left.left, right.right) //对称必要条件：左左=右右
                && isSymmetricTree(left.right, right.left); //对称必要条件：左右=右左
    }

    //迭代算法
    public boolean isSymmetricIteration(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue; //左右皆空，对称，继续循环
            if (left == null || right == null) return false; //左右一个空，不对称
            if (left.val != right.val) return false; //对称必要条件：值相等
            //对称必要条件：左左=右右，加入队列，下次循环判断
            queue.offer(left.left);
            queue.offer(right.right);
            //对称必要条件：左右=右左，加入队列，下下次循环判断
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
