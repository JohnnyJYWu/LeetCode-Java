package com.johnnyjywuu.t41_60;

/**
 * @author Created by Johnny Wu on 2019/8/28.
 * @title 45. 跳跃游戏 II
 * @link https://leetcode-cn.com/problems/jump-game-ii
 * @description
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 */

public class T045_jump {
    public int jump(int[] nums) {
        int steps = 0;
        int maxPosition = 0;
        int endPosition = 0; //记录边界位置，每达到边界，步数+1

        for (int i = 0; i < nums.length - 1; i ++) {
            //找能跳的最远的位置
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == endPosition) { //遇到边界位置，就更新边界，并且步数+1
                endPosition = maxPosition;
                steps ++;
            }
        }
        return steps;
    }
}
