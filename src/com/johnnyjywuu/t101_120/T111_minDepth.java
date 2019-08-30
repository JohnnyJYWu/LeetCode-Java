package com.johnnyjywuu.t101_120;

import com.johnnyjywuu.model.TreeNode;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title
 * @link
 * @description
 */

public class T111_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //由于最小深度是到叶子结点的最短长度，当前结点左子树或右子树为空时不能比较空的值
        if (root.left == null && root.right != null) return 1 + minDepth(root.right);
        if (root.right == null && root.left != null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
