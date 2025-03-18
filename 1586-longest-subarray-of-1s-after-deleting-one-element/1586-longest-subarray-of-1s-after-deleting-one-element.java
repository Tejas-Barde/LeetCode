class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0,right = 0,result = 0;
        int zero = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zero++;
                while(zero > 1) if(nums[left++] == 0) zero--;
            }
            right++;
            result = Math.max(result,right-left-1);
        }
        return result;
    }
}