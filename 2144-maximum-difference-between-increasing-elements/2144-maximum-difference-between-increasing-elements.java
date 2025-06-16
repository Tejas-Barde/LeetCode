class Solution {
    public int maximumDifference(int[] nums) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            min = Math.min(min,n);
            result = Math.max(result,n-min);
        }
        return result==0?-1:result;
    }
}