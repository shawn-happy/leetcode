## Description
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

## Examples
### Example 1
```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
```

### Example 2
```
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
```

## Constraints
* nums1.length == m
* nums2.length == n
* 0 <= m <= 1000
* 0 <= n <= 1000
* 1 <= m + n <= 2000
* -106 <= nums1[i], nums2[i] <= 106

## Solutions
### java
**二分查找：**
```java
class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0;
        }
        
        if(nums1 == null){
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }
        
        if(nums2 == null){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }
        
        if(nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        
        // choose shorter to binary search
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;
        
        while(left < right){
            int i = (left + right) / 2;
            int j = (n + m) / 2 - i;
            
            if(nums1[i] < nums2[j - 1]){
                left = i + 1;
            }else{
                right = i;
            }
        }
        
        int first = left;
        int second = (n + m) / 2 - left;
        
        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];
        
        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];
        
        if((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        }else{
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }
    }
}
```
**合并有序数组**
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
		int len2 = nums2.length;
		int[] newArr = new int[len1 + len2];
		int i = 0;
		int j = 0;
		int k = 0;
		int m = (len1 + len2) % 2;
		int n = (len1 + len2) / 2;
		while (i < len1 && j < len2){
			if(nums1[i] <= nums2[j]){
				newArr[k ++] = nums1[i++];
			}else{
				newArr[k ++] = nums2[j ++];
			}

		}
		while (i < len1){
			newArr[k ++] = nums1[i++];
		}

		while (j < len2){
			newArr[k ++] = nums2[j++];
		}

		// 如果是奇数
		if(m == 1){
			return newArr[n];
		}
		// 如果是偶数
		if(m == 0){
			return (newArr[n - 1] + newArr[n]) / 2.0;
		}

		return 0;
    }
}
```
### python
```python
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        N = len(nums1)
        M = len(nums2)
        if N > M:
            return self.findMedianSortedArrays(nums2, nums1)

        lo = 0
        hi = N
        combined = N + M

        while lo <= hi:
            mid1 = lo + hi >> 1
            mid2 = ((combined + 1) >> 1) - mid1

            leftp1 = -float("inf") if mid1 == 0 else nums1[mid1 - 1]
            rightp1 = float("inf") if mid1 == N else nums1[mid1]

            leftp2 = -float("inf") if mid2 == 0 else nums2[mid2 - 1]
            rightp2 = float("inf") if mid2 == M else nums2[mid2]

            # Check if the partition is valid for the case of
            if leftp1 <= rightp2 and leftp2 <= rightp1:
                if combined % 2 == 0:
                    return (max(leftp1, leftp2)+min(rightp1, rightp2)) / 2.0

                return max(leftp1, leftp2)
            else:
                if leftp1 > rightp2:
                    hi = mid1 - 1
                else:
                    lo = mid1 + 1
        return -1
```