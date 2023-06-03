package LeetCode.SearchAndSort;

import java.util.HashMap;
import java.util.Map;
// https://leetcode-cn.com/problems/4sum-ii/
// 454. 四数相加 II
// 用hashmap存储两个数组的和，然后遍历另外两个数组，看看是否有和为0的情况
// 时间复杂度：O(n^2) 空间复杂度：O(n^2)
// 分组的考虑，四个数组分为两组，时间复杂度可以最优为O(n^2)
public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> numMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i:nums1){
            for(int j:nums2){
                sum = i+j;
                numMap.put(sum, numMap.getOrDefault(sum, 0)+1);
            }
        }
        for(int p:nums3){
            for(int q:nums4){
                if(numMap.containsKey(-(p+q))){
                    count += numMap.get(-(p+q));
                }
            }
        }
        return count;
    }
}
