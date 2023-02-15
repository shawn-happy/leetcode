package com.shawn.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

/** 仅用一个队列来实现栈 */
public class Solution10 {

  private Queue<Integer> queue1;

  public Solution10() {
    queue1 = new LinkedList<>();
  }

  public void push(int x) {
    int size = queue1.size();
    queue1.offer(x);
    for (int i = 0; i < size; i++) {
      queue1.offer(queue1.poll());
    }
  }

  public int pop() {
    return queue1.isEmpty() ? -1 : queue1.poll();
  }

  public int top() {
    return queue1.isEmpty() ? -1 : queue1.peek();
  }

  public boolean empty() {
    return queue1.isEmpty();
  }
}
