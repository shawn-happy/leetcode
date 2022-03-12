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