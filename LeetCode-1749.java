class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = 0,sum = 0;
        for(int i = 0;i<n;i++){
            sum = (nums[i] + sum > nums[i]) ? nums[i] + sum : nums[i];
            max = Math.max(max,sum);
        }
        int min = 0;
        sum = 0;
        for(int i = 0;i<n;i++){
            sum = (nums[i] < sum+nums[i]) ? nums[i] : nums[i]+sum;
            min = Math.min(min,sum);
        }
        return Math.max(max, -1*min);
    }
}