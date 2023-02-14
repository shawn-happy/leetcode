package com.shawn.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

  private final Deque<Integer> tailStack;
  private final Deque<Integer> headStack;

  public CQueue() {
    tailStack = new ArrayDeque<>();
    headStack = new ArrayDeque<>();
  }

  public void appendTail(int value) {
    tailStack.push(value);
  }

  public int deleteHead() {
    if (headStack.isEmpty()) {
      while (tailStack.size() != 0) {
        Integer data = tailStack.pop();
        headStack.push(data);
      }
    }
    if (headStack.isEmpty()) {
      return -1;
    }
    return headStack.pop();
  }

}
