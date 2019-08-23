package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/22.
 * @title 11. 盛最多水的容器
 * @link https://leetcode-cn.com/problems/container-with-most-water
 * @description
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *  
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

public class T011_maxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        // 双指针
        int left = 0, right = height.length -1;

        while (left < right) {
            int width = Math.min(height[left], height[right]);// 木桶原理
            maxArea = Math.max(maxArea, (right - left) * width);
            if (height[left] <= height[right]) {// 由于宽度由较小的决定（木桶原理），因此保留较长的板，短板指针往长版移动，试图寻找更长的板
                left ++;
            } else {
                right --;
            }
        }

        return maxArea;
    }
}
