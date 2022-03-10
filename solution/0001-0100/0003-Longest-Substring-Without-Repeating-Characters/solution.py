class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = right = result = 0
        map = {}
        
        while right < len(s):
            c = s[right]
            if c in map:
                left = max(map[c], left)
            result = max(result, right - left + 1)
            right = right + 1
            map[c] = right
        return result