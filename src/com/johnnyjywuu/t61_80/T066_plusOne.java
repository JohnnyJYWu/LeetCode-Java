package com.johnnyjywuu.t61_80;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title 66. 加一
 * @link https://leetcode-cn.com/problems/plus-one
 * @description
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class T066_plusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] ++;
            if (digits[i] == 10) { //9+1=10时，该位归零，继续循环对前一位+1
                digits[i] = 0;
            } else { //普通加法不进位，直接返回
                return digits;
            }
        }
        //此时，digits全为0（即999……9 + 1 = 1000……0的情况)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
