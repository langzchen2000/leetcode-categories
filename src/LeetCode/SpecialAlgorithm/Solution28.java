package LeetCode.SpecialAlgorithm;
// https://leetcode-cn.com/problems/implement-strstr/
// 28. 找出字符串中第一个匹配项的下标
// KMP算法
//

public class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] cNeedle = needle.toCharArray();
        char[] cHaystack = haystack.toCharArray();
        int[] next = constructNext(cNeedle);

        int now = 0;
        int ptr = -1;
        int len = haystack.length();
        int nlen = needle.length();
        while (now < len) {
            while (ptr >= 0 && cHaystack[now] != cNeedle[ptr+1]) {
                ptr = next[ptr];
            }
            if (cHaystack[now] == cNeedle[ptr+1]) {
                if (ptr + 1 == nlen - 1) {
                    return now - ptr-1;
                } else {
                    ptr++;
                }
            }
            now++;
        }
        return -1;
    }


    public int[] constructNext(char[] needle){
        int j=-1;
        int len = needle.length;
        int i = 1;
        int[] next = new int[len];
        next[0] = -1;
        while(i<len){
            while(j >= 0 && needle[i] != needle[j+1]) j=next[j];
            if(needle[i] == needle[j+1]) j++;
            next[i] = j;
            i++;
        }
        return next;
    }
}
