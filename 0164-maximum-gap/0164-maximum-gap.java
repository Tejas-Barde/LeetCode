class Solution {
    public int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        if(min == max) return 0;
        int n = nums.length;
        int bucketSize = (int)Math.ceil((double)(max-min)/(n-1));
        int[] minBucket = new int[n];
        int[] maxBucket = new int[n];
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,Integer.MIN_VALUE);
        for(int num : nums){
            int idx = (num-min) / bucketSize;
            minBucket[idx] = Math.min(minBucket[idx],num);
            maxBucket[idx] = Math.max(maxBucket[idx],num);  
        }
        int maxGap = bucketSize;
        int previous = maxBucket[0];
        for(int i = 1;i<n;i++){
            if(minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap,minBucket[i] - previous);
            previous = maxBucket[i];
        }
        return maxGap;
    }
}