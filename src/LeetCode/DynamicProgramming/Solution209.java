package LeetCode.DynamicProgramming;

public class Solution209 {
    //dynamic programming
    //for each num of nums, we can reduce the constrain to the subarray sum that contains the nums[i]
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum > target && sum - nums[left] >= sum) {
                left++;
            }
            if(sum >= target) min = Math.min(min, i - left + 1);
        }
        return min;
    }
}
