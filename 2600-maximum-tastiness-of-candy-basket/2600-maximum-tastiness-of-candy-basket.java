class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low=0;
        int high=price[price.length-1];
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,price,k)){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
    public boolean isValid(int target,int[] price,int k){
        int prev=price[0];
        int cnt=1;
        for(int i=1;i<price.length;i++){
            if(price[i]-prev>=target){
                cnt++;
                prev=price[i];
            }
        }
        if(cnt>=k)
            return true;
        return false;
    }
}