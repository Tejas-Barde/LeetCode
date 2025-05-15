class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }

    private int rob(int[] nums,int start,int end){
        int[] dp = new int[nums.length];
        for(int i = end;i>=start;i--){
            if(i + 2 > end){
                dp[i] = nums[i];    
                continue;
            } 
            if(i + 3 > end){
                dp[i] = nums[i] + nums[i+2];
                continue;
            }
            dp[i] = Math.max(dp[i+2],dp[i+3]) + nums[i];
        }
        return Math.max(dp[start],dp[start+1]);
    }
}