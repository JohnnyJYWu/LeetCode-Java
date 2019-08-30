package com.johnnyjywuu.t101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/30.
 * @title 119. 杨辉三角 II
 * @link https://leetcode-cn.com/problems/pascals-triangle-ii
 * @description
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */

public class T119_getRow {
    public List<Integer> getRow(int rowIndex) { //同T118
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;

        result.add(1);

        for (int i = 1; i <= rowIndex; i ++) {
            List<Integer> preRow = result;
            result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < i; j ++) {
                result.add(preRow.get(j - 1) + preRow.get(j));
            }
            result.add(1);
        }

        return result;
    }

    //公式法：https://pic.leetcode-cn.com/195de01eae91e09de14dd13daafbef986c42345f2bdef405153a1742175079f4.jpg
    //C n k = n!/(k!(n−k)!)=(n∗(n−1)∗(n−2)∗...(n−k+1))/k!
    public List<Integer> getRow_formula(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        for (int k = 0; k <= N; k++) {
            ans.add(Combination(N, k));
        }
        return ans;
    }

    private int Combination(int N, int k) {
        long res = 1;
        for (int i = 1; i <= k; i ++)
            res = res * (N - k + i) / i;
        return (int) res;
    }

    //优化
    //C n k = C n k−1 ×(n−k+1)/k
    public List<Integer> getRow_formula_opt(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k ++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }
}
