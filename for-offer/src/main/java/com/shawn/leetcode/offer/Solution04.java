package com.shawn.leetcode.offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * <p>示例 1：
 *
 * <p>输入：s = "We are happy." 输出："We%20are%20happy."
 *
 * <p>限制：
 *
 * <p>0 <= s 的长度 <= 10000
 */
public class Solution04 {
  public static String replaceSpace(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }

    int length = s.length();
    int blankCount = 0;
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == ' ') {
        blankCount++;
      }
    }
    char[] newChar = new char[length + blankCount * 2];
    int p1 = length - 1;
    int p2 = newChar.length - 1;
    while (p1 >= 0 && p1 <= p2) {
      if (chars[p1] == ' ') {
        newChar[p2--] = '0';
        newChar[p2--] = '2';
        newChar[p2--] = '%';
      } else {
        newChar[p2] = chars[p1];
        p2--;
      }
      p1--;
    }
    return String.valueOf(newChar);
  }

  public static void main(String[] args) {
    String s = "We are happy.";
    System.out.println(replaceSpace(s));
  }
}
