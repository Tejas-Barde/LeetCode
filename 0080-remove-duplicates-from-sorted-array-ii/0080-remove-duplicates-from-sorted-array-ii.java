class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int e : nums){
            if( i == 0 || i == 1 || e != nums[i-2]){
                nums[i] = e;
                i++;
            }
        }
        return i;
    }
}