class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int left = 1,right = nums[0];
        for(int num : nums) right = Math.max(right,num);
        while(left < right){
            int mid= left + (right-left)/2;
            // System.out.println(mid);
            int ops = 0;
            for(int num : nums){
                ops += (num/mid)-1;
                if(num % mid != 0) ops++;
            }
            // System.out.println("ops - "+ops);
            if(ops > maxOperations) left = mid+1;
            else right = mid; 
        }
        return left;
    }
}