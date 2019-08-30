package com.johnnyjywuu.t41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/28.
 * @title 46. 全排列
 * @link https://leetcode-cn.com/problems/permutations
 * @description
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class T046_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 0) return result;

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
