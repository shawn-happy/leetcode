package com.shawn.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * <p>F(0) = 0, F(1) = 1 F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 斐波那契数列由 0 和 1
 * 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * <p>
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：n = 2 输出：1 示例 2：
 *
 * <p>输入：n = 5 输出：5
 *
 * <p>
 *
 * <p>提示：
 *
 * <p>0 <= n <= 100
 */
public class Solution07 {

  private static final Map<Integer, Integer> valueMap = new HashMap<>();

  public int fib(int n) {
    if (n == 0) {
      valueMap.put(0, 0);
      return 0;
    }
    if (n == 1) {
      valueMap.put(1, 1);
      return 1;
    }
    if (valueMap.containsKey(n)) {
      return valueMap.get(n);
    }
    return fib(n - 1) + fib(n - 2);
  }

  public int fib2(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int fib3(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int one = 1;
    int two = 0;
    int fib = 0;
    for (int i = 2; i <= n; i++) {
      fib = one + two;
      two = one;
      one = fib;
    }
    return fib;
  }

  public static void main(String[] args) {
    Solution07 solution07 = new Solution07();
    int i = solution07.fib3(7);
    System.out.println(i);
  }
}
