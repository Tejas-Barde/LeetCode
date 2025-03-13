class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 1 , right = queries.length;
        if(Arrays.stream(nums).allMatch(x -> x == 0)) return 0;
        if(!isZeroArray(right,nums,queries)) return -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(isZeroArray(mid,nums,queries)) right = mid-1;
            else left = mid+1;
        }
        return left;
    }

    private boolean isZeroArray(int k,int[] nums, int[][] q){
        int[] diff = new int[nums.length+1];
        for(int i = 0;i<k;i++){
            diff[q[i][0]] -= q[i][2];
            diff[q[i][1]+1] += q[i][2];
        }
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += diff[i];
            if(sum + nums[i] > 0) return false;
        }
        return true;
    }
}