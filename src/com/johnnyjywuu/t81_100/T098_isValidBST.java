package com.johnnyjywuu.t81_100;

import com.johnnyjywuu.model.TreeNode;

import java.util.Stack;

/**
 * @author Created by Johnny Wu on 2019/9/3.
 * @title 98. 验证二叉搜索树
 * @link https://leetcode-cn.com/problems/validate-binary-search-tree
 * @description
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
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

public class T098_isValidBST {
    public boolean isValidBST(TreeNode root) {
        //中序遍历，结果为从小到大即是二叉搜索树
        Stack<TreeNode> stack = new Stack<>();
        double lastNodeVal = -Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= lastNodeVal) return false;
            lastNodeVal = root.val;
            root = root.right;
        }

        return true;
    }
}
