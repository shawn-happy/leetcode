package com.shawn.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 * <p>在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * <p>示例 1：
 *
 * <p>输入： [2, 3, 1, 0, 2, 5, 3] 输出：2 或 3
 *
 * <p>限制：
 *
 * <p>2 <= n <= 100000
 */
public class Solution01 {

  public static void main(String[] args) {
    int[] nums = {2, 1, 1, 5, 2, 5, 3};
    System.out.println(new Solution01().findRepeatNumber1(nums));
    System.out.println(new Solution01().findRepeatNumber2(nums));
  }

  public int findRepeatNumber1(int[] nums) {
    Set<Integer> result = new HashSet<>();
    for (int num : nums) {
      if (result.contains(num)) {
        return num;
      }
      result.add(num);
    }
    return -1;
  }

  public int findRepeatNumber2(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] == i) {
        i++;
        continue;
      }
      if (nums[nums[i]] == nums[i]) {
        return nums[i];
      }
      int tmp = nums[i];
      nums[i] = nums[tmp];
      nums[tmp] = tmp;
    }
    return -1;
  }
}
