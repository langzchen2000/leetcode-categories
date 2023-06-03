package LeetCode.SearchAndSort;
//merge sort
class Solution997 {
    public int[] sortedSquares(int[] nums) {
        //merge sort
        int leftPtr = -1;
        int rightPtr = nums.length;

        while(leftPtr + 1 < nums.length && nums[leftPtr + 1] < 0) leftPtr++;
        while(rightPtr - 1 >= 0 && nums[rightPtr - 1] >= 0) rightPtr--;

        int[] result = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int leftSquare = leftPtr != -1 ? nums[leftPtr] * nums[leftPtr] : -1;
            int rightSquare = rightPtr != nums.length ? nums[rightPtr] * nums[rightPtr] : -1;
            if(leftPtr == -1) {
                result[i] = rightSquare;
                rightPtr++;
                continue;
            }
            if(rightPtr == nums.length) {
                result[i] = leftSquare;
                leftPtr--;
                continue;
            }
            if(leftSquare >= rightSquare) {
                result[i] = rightSquare;
                rightPtr++;
                continue;
            }
            if( leftSquare < rightSquare){
                result[i] = leftSquare;
                leftPtr--;
                continue;
            }
        }
        return result;


    }
}
