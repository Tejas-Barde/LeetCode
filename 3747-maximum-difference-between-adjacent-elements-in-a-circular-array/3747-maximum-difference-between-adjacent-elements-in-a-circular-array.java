class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int result = Integer.MIN_VALUE;
        int prev = nums[nums.length-1];
        for(int curr : nums){
            result = Math.max(Math.abs(curr-prev),result);
            prev = curr;
        }
        return result;
    }
}