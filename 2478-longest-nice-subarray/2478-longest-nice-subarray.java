class Solution {
    public int longestNiceSubarray(int[] nums) {
        int right = 0;
        int left = 0;
        int or = 0;
        int result = 0;
        while(right < nums.length){
            while((or & nums[right]) != 0){
                or ^= nums[left];
                left++;
            }
            or |= nums[right];
            right++;
            result = Math.max(result , right - left);
        }
        return Math.max(result , right - left);
    }
}