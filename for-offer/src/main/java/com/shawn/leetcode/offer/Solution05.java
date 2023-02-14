package com.shawn.leetcode.offer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2] 输出：[2,3,1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class Solution05 {

  public int[] reversePrint(ListNode head) {
    ListNode p = head;
    if (head == null) {
      return null;
    }
    Stack<Integer> stack = new Stack<>();
    while (p != null) {
      stack.add(p.val);
      p = p.next;
    }
    int[] res = new int[stack.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = stack.pop();
    }
    return res;
  }

}
