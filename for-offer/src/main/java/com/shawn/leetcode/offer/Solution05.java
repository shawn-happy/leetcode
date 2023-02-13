package com.shawn.leetcode.offer;

import java.util.Stack;

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

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
