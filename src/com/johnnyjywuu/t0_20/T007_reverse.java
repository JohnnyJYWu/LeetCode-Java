package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/22.
 * @title 7. 整数反转
 * @link https://leetcode-cn.com/problems/reverse-integer
 * @description
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class T007_reverse {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int num = x % 10;
            x /= 10;
            // 溢出，返回0
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && num > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            result = result * 10 + num;
        }

        return result;
    }
}
