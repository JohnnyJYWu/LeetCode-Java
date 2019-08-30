package com.johnnyjywuu.t0_20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Johnny Wu on 2019/8/13.
 * @title 1. 两数之和
 * @link https://leetcode-cn.com/problems/two-sum/
 * @description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class T001_twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //反着放，key为值，value为nums在数组中的位置(index)
        }

        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];
            if (map.containsKey(differ) && map.get(differ) != i) { //Integer比较时有优化，默认比较值而不是对象地址
                return new int[]{i, map.get(differ)};
            }
        }

        return null;
    }
}
