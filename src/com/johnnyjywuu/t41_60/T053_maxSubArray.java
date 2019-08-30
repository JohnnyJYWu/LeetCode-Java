package com.johnnyjywuu.t41_60;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title 53. 最大子序和
 * @link https://leetcode-cn.com/problems/maximum-subarray
 * @description
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class T053_maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (Integer num : nums) {
            if (sum < 0) { //sum<0时说明该num前的子字符串和小于0了，直接以此num为新子字符串的起点开始加吧
                sum = num;
            } else { //否则尝试加新的num找和更大的子串
                sum += num;
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
