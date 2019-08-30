package com.johnnyjywuu;

import com.johnnyjywuu.model.ListNode;
import com.johnnyjywuu.model.TreeNode;
import sun.rmi.runtime.Log;

/**
 * @author Created by Johnny Wu on 2019/8/27.
 * @title
 * @link
 * @description
 */

public class Utils {
    /**
     * 构建普通链表 ListNode
     * @param nodeVals
     * @return ListNode head
     */
    public static ListNode buildListNode(int[] nodeVals) {
        if (nodeVals == null || nodeVals.length <= 0) {
            System.err.println("buildListNode: invalid nodeVals");
            return new ListNode(0);
        }

        ListNode preHead = new ListNode(0);
        ListNode buildNode = preHead;
        for (Integer val : nodeVals) {
            buildNode.next = new ListNode(val);
            buildNode = buildNode.next;
        }

        return preHead.next;
    }

    /**
     * 构建普通二叉树 TreeNode
     * @param nodeVals
     * @return TreeNode root
     */
    public static TreeNode buildTreeNode(Integer[] nodeVals) {
        if (nodeVals == null || nodeVals.length <= 0) {
            System.err.println("buildTreeNode: invalid nodeVals");
            return new TreeNode(0);
        }

        return buildTreeNode(nodeVals, 0);
    }
    private static TreeNode buildTreeNode(Integer[] nodeVals, int index) {
        if (index >= nodeVals.length || nodeVals[index] == null) return null;

        TreeNode node = new TreeNode(nodeVals[index]);
        node.left = buildTreeNode(nodeVals, index * 2 + 1); //结点左子树在数组中的位置 index * 2 + 1
        node.right = buildTreeNode(nodeVals, index * 2 + 2); //结点右子树在数组中的位置 index * 2 + 2

        return node;
    }
}
