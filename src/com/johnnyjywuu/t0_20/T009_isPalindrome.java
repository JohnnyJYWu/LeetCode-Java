package com.johnnyjywuu.t0_20;

/**
 * @author Created by Johnny Wu on 2019/8/22.
 * @title 9. 回文数
 * @link https://leetcode-cn.com/problems/palindrome-number
 * @description
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */

public class T009_isPalindrome {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;

//        // 转换成字符串进行判断
//        return isPalindrome(x + "");

        // 把后半部分数字反转，与前半部分比较
        int num = 0;// 后半部分数字，从后往前加
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        // 如果x长度为奇数，会出现num比x多一位的情况
        return x == num || x == num / 10;
    }

    // 转换成字符串进行判断，头尾比较即可
    public boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i ++;
            j --;
        }

        return true;
    }
}
