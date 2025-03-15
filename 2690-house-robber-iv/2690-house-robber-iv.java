class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int n : nums){
            left = Math.min(n,left);
            right = Math.max(right,n);
        }
        while(left <= right){
            int mid = (left+right) >> 1;
            if(check(mid,nums,k)) right = mid-1;
            else left = mid+1;
        }
        return left;
    }

    private boolean check(int c,int[] nums,int k){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= c){
                i++;
                count++;
            } 
            if(count == k) return true;
        }
        return false;
    }
}