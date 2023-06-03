package LeetCode.DoublePointer;
import java.util.*;
//using hashmap
//double pointer forms a sliding window
//dynamic programming: for each character, we check if it appears before. The left pointer updates itself.
//i-left+1 means the length of the substring that contains no repeated character and contains s.charAt(i)
//state transition equation is not suitable for math representation. Code is a better representation.
//why it is dynamic programming, dp[i] is only related to dp[0] to dp[i] and s.charAt(0) to s.charAt(i).

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}

