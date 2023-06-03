package LeetCode.SearchAndSort;

public class Solution383 {
    // https://www.leetcode.cn/problems/ransom-note/
    // 383. 赎金信
    //因为可能的元素有限，构建数组哈希表，题目本质上在问ransomNote中的字符是否都在magazine中，且个数不超过magazine中的个数
    //时间复杂度：O(m+n) 空间复杂度：O(1) 因为数组的大小是固定的
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(char c:magazine.toCharArray()){
            count[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            count[c-'a']--;
            if(count[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
