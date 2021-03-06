package com.johnnyjywuu.t41_60;

/**
 * @author Created by Johnny Wu on 2019/8/29.
 * @title 50. Pow(x, n)
 * @link https://leetcode-cn.com/problems/powx-n
 * @description
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */

public class T050_myPow {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        long N = n; //n数值范围是 [−2^31, 2^31 − 1]

        return N < 0 ? 1 / xPowN(x, -N) : xPowN(x, N); //x^-n = 1/x^n
    }

    private double xPowN(double x, long n) {
        if (n == 1) return x; //n=1时跳出
        //n为奇数时需将递归结果【乘当前x】，递归为 x^n = (x*x)^(n/2)
        return n % 2 == 0 ? xPowN(x * x, n / 2) : xPowN(x * x, n / 2) * x;
    }
}
