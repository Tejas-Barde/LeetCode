class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0,right = 0,zero = 0;
        int result = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zero++;
                while(zero > k) if(nums[left++] == 0) zero--;
            }
            right++;
            result = Math.max(result,right-left);
        }
        return result;
    }
}