package com.shawn.leetcode.offer;

public class Solution03 {
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int i = 0;
    int rows = matrix.length;
    int columns = matrix[0].length;
    int j = columns - 1;
    while (i < rows && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      }
      if (matrix[i][j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }
}
