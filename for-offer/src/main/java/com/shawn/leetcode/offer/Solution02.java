package com.shawn.leetcode.offer;

/**
 * 找出数组中重复的数字。
 *
 * <p>在一个长度为 n + 1 的数组 nums 里的所有数字都在 1 ~ n 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * <p>示例 1：
 *
 * <p>输入： [2, 3, 5, 4, 3, 2, 6, 7] 输出：2 或 3
 *
 * <p>限制：
 *
 * <p>2 <= n <= 100000
 */
public class Solution02 {

  public static void main(String[] args) {
    int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
    System.out.println(new Solution02().findRepeatNumber2(nums));
  }

  public int findRepeatNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int[] newNums = new int[nums.length];
    for (int num : nums) {
      if (newNums[num] == num) {
        return num;
      }
      newNums[num] = num;
    }
    return -1;
  }

  public int findRepeatNumber2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int length = nums.length;
    int start = 1;
    int end = length - 1;
    while (end >= start) {
      int middle = ((end - start) >> 1) + start;
      int count = countRange(nums, start, middle);
      if (end == start) {
        if (count > 1) {
          return start;
        } else {
          break;
        }
      }
      if (count > (middle - start + 1)) {
        end = middle;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }

  public int countRange(int[] nums, int start, int end) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int num : nums) {
      if (num >= start && num <= end) {
        count++;
      }
    }
    return count;
  }
}
