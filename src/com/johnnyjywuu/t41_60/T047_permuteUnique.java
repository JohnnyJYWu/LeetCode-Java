package com.johnnyjywuu.t41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/28.
 * @title 47. 全排列 II
 * @link https://leetcode-cn.com/problems/permutations-ii
 * @description
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

public class T047_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) return result;

        Arrays.sort(nums); //先排序，用于去重
        boolean[] isUsed = new boolean[nums.length]; //isUsed用于标记数组对应位置的数是否已经使用过

        backtrack(result, new ArrayList<>(), isUsed, nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> list, boolean[] isUsed, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (!isUsed[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                isUsed[i] = true;
                //递归排列
                backtrack(result, list, isUsed, nums);
                //回溯
                isUsed[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
