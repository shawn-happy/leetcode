package com.shawn.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。</p>
 * <p>
 * 示例 1:
 * <image src="./image/img.png" />
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] Output: [3,9,20,null,null,15,7]
 * <p>
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1] Output: [-1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class Solution06 {

  private static final Map<Integer, Integer> valueIndexMap = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
      return null;
    }
    for (int i = 0; i < inorder.length; i++) {
      valueIndexMap.put(inorder[i], i);
    }
    return rebuild(preorder,0, preorder.length - 1, 0, inorder.length - 1);
  }

  public TreeNode rebuild(int[] preorder,int preOrderLeft, int preOrderRight,
      int inorderLeft, int inorderRight) {
    if (preOrderLeft > preOrderRight) {
      return null;
    }
    int root = preorder[preOrderLeft];
    if (!valueIndexMap.containsKey(root)) {
      throw new RuntimeException();
    }
    int inorderRootIndex = valueIndexMap.get(root);
    int inorderLeftSize = inorderRootIndex - inorderLeft;
    TreeNode rootNode = new TreeNode(root);
    rootNode.left = rebuild(preorder, preOrderLeft + 1, preOrderLeft + inorderLeftSize,
        inorderLeft, inorderRootIndex - 1);
    rootNode.right = rebuild(preorder, preOrderLeft + inorderLeftSize + 1, preOrderRight,
        inorderRootIndex + 1, inorderRight);
    return rootNode;
  }
}
