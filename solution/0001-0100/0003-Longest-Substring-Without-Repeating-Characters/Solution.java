import java.util.HashMap;
import java.util.Map;

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