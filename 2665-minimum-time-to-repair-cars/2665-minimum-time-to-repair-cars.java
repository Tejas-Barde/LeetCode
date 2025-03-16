class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1,right = (long)1e14;
        long mid = 1;
        while(left <= right){
            mid = (left+right)/2;
            if(check(mid,ranks,cars)) right = mid-1;
            else left = mid+1;
        }
        return (left);
    }

    private boolean check(long time,int[] ranks,int cars){
        long count = 0;
        for(int r : ranks){
            count += (long)(Math.sqrt(time/r));
        }
        return count >= cars;
    }
}