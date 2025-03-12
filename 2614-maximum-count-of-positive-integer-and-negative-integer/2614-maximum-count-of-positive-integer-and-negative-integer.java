class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int start = 0,end = n-1;
        int mid = 0;
        while(start <= end){
            mid = (start+end)/2;
            if(nums[mid] == 0) {
                start = mid;
                while(start >= 0 && nums[start] == 0) start--;
                end = mid;
                while(end < n && nums[end] == 0) end++;
                return Math.max(start+1,n-end);
            }
            if(nums[mid] < 0) start = mid+1;
            else end = mid-1;
        }
        if(nums[mid] > 0) return Math.max(mid,n-mid);
        return Math.max(mid+1,n-mid-1);
    }
}