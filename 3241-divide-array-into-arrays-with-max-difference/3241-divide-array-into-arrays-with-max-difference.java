class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] result = new int[n/3][];
        for(int i = 0;i<n;i+=3){
            if(nums[i+2] - nums[i] <= k){
                result[i/3] = new int[]{
                    nums[i],
                    nums[i+1],
                    nums[i+2]
                };
            }
            else return new int[0][0];
        }
        return result;
    }
}