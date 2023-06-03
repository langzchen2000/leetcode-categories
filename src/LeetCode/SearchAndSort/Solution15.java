package LeetCode.SearchAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode-cn.com/problems/3sum/
// 15. 三数之和
//看到去重，想到先排序，排序过后相同的数字会排在一起
//以其中一个数字为起点，另外两个数字从两端向中间靠拢，实际上是借鉴了两数之和的方法
//这里需要注意的是，如果当前的数字和上一个数字相同，那么就会出现重复，所以需要跳过
//如果当前的数字大于0，那么三数之和一定大于0，所以直接跳过
//时间复杂度：O(n^2) 空间复杂度：O(1)（不考虑结果的空间）
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
