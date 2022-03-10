## Description
Given a string s, find the length of the longest substring without repeating characters.

## Examples
### Example 1
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

### Example 2
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

### Example 3
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

## Constraints
* 0 <= s.length <= 5 * 104
* s consists of English letters, digits, symbols and spaces.

## Solutions

### java
```java
class Solution{

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(map.get(c), left);
            }
            map.put(c, ++right);
            ans = Math.max(ans, right - left);  
        }
        return ans;    
    }
}
```

### python
```python
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
```