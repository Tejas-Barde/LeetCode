class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if(n == 2) return stones[1];
        int start = 0,end = stones[n-1] + 1;
        while(start < end){
            int mid = start + (end-start)/2;
            boolean flag = false;
            for(int i = 2;i<n;i+=2){
                if(stones[i]-stones[i-2] > mid){
                    flag = true;
                    break; 
                } 
            }
            for(int i = 3;i<n;i+=2){
                if(stones[i]-stones[i-2] > mid){
                    flag = true;
                    break; 
                } 
            }
            if(flag) start = mid+1;
            else end = mid;
        }
        return start;
    }
}