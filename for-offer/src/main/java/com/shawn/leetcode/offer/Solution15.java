package com.shawn.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution15 {

  public ListNode reverse(ListNode head) {
    ListNode p = head;
    Deque<Integer> stack = new LinkedList<>();
    while (p != null) {
      stack.push(p.val);
      p = p.next;
    }
    if (stack.isEmpty()) {
      return null;
    }
    ListNode newHead = new ListNode(0);
    ListNode dummyNode = newHead;
    while (!stack.isEmpty()) {
      ListNode node = new ListNode(stack.pop());
      dummyNode.next = node;
    }
    return newHead.next;
  }

  public ListNode reverse2(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode newHead = reverse2(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  public ListNode reverse3(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
