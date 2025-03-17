class Solution {
    public boolean divideArray(int[] nums) {
        int[] map = new int[501];
        for(int i = 0;i<nums.length;i++) map[nums[i]]++;
        for(int m:map) if(m%2 != 0) return false;
        return true;
    }
}