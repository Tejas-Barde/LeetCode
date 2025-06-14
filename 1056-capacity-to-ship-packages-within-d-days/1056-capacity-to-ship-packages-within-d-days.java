class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1,right = 0;
        for(int w : weights) right += w;
        while(left < right){
            int mid = left + (right-left)/2;
            // System.out.println(mid);
            int sum = 0;
            int d = 1;
            for(int w : weights){
                if(sum + w <= mid){
                    sum += w;
                }
                else{
                    // System.out.println(d);
                    if(w > mid){
                        d = days+1;
                        break;
                    } 
                    sum = w;
                    d++;
                    if(d > days) break;
                }
            }
            // System.out.println("days--"+d);
            if(d > days) left = mid+1;
            else right = mid;
        }
        return left;   
    }
}