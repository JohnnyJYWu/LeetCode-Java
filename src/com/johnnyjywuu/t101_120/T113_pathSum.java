package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/9/2.
 * @title 113. 路径总和 II
 * @link https://leetcode-cn.com/problems/path-sum-ii
 * @description
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

public class T113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        findPath(result, root, sum, new ArrayList<>());

        return result;
    }

    private void findPath(List<List<Integer>> result, TreeNode node, int sum, List<Integer> path) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && sum - node.val == 0) { //叶子结点且和为sum，添加路径到结果
            result.add(new ArrayList<>(path));
        }
        //对左右子树递归查找
        findPath(result, node.left, sum - node.val, path);
        findPath(result, node.right, sum - node.val, path);
        //回溯
        path.remove(path.size() - 1);
    }
}
