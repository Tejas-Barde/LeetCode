class Solution {
    public int minOperations(int[] nums) {
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                if(nums.length - i < 3) return -1;
                for(int j = i;j<i+3;j++) nums[j] = (nums[j]==1)?0:1;
                k++;
            }
        }
        return k;
    }
}