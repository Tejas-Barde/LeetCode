class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        long sum = 0;
        int max = Integer.MIN_VALUE;    
        for(int i = 0;i<n;i++){
            sum += candies[i];
            max = Math.max(candies[i],max);
        }
        if(sum < k) return 0;
        int left = 1,right = max;
        int result = 0;
        while(left <= right){
            int mid = (left+right)/2;
            if(canGetCandies(mid,candies,k)) left = (result = mid)*0 + mid+1;
            else right = mid-1;
        }
        return result;
    }

    private boolean canGetCandies(int c,int[] candies ,long k){
        long sum = 0;
        for(int i = 0;i<candies.length;i++){
            sum += candies[i]/c;
            if(sum >= k) return true;
        }
        return false;
    }
}