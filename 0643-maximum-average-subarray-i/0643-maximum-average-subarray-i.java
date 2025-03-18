class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0,maxAvg = 0.0;
        for(int i = 0;i<k;i++) sum += nums[i];
        maxAvg = (double)sum/k;
        for(int i = k;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg,(double)(sum/k));
        }
        return maxAvg;
    }
}