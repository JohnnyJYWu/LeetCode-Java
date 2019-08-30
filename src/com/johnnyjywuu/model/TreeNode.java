package com.johnnyjywuu.model;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title 二叉树结点
 * @link
 * @description 一般二叉树结点
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * @return 层遍历输出，不含null
     * System.out.println(Utils.buildTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7}).getLevelOrder());
     */
    public String getLevelOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> level : levelOrder(this)) {
            stringBuilder.append(level.toString() + "\n");
        }
        return stringBuilder.toString();
    }
    private List<List<Integer>> levelOrder(TreeNode root) {
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

    /**
     * @return 层遍历输出，含null
     * System.out.println(Utils.buildTreeNode(new Integer[] {3, 9, 20, null, null, 15, 7}).getLevelOrderWithNull());
     */
    public String getLevelOrderWithNull() {
        StringBuilder stringBuilder = new StringBuilder();
        List<List<Integer>> tree = levelOrderWithNull(this);
        for (int i = 0; i < tree.size() - 1; i ++) { // 最后一行全是null不打印了
            List<Integer> level = tree.get(i);
            stringBuilder.append("[");
            for (int j = 0; j < level.size(); j ++) {
                stringBuilder.append(level.get(j) == Integer.MIN_VALUE ? "null" : level.get(j));
                stringBuilder.append(j == level.size() - 1 ? "" : ", ");
            }
            stringBuilder.append("]\n");
        }
        return stringBuilder.toString();
    }
    private List<List<Integer>> levelOrderWithNull(TreeNode root) {
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
                    if (node == null) {
                        list.add(Integer.MIN_VALUE);
                    } else {
                        list.add(node.val);
                        queue2.offer(node.left);
                        queue2.offer(node.right);

                    }
                }
                result.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.poll();
                    if (node == null) {
                        list.add(Integer.MIN_VALUE);
                    } else {
                        list.add(node.val);
                        queue1.offer(node.left);
                        queue1.offer(node.right);
                    }
                }
                result.add(list);
            }
        }

        return result;
    }
}
