class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int j = 0;
        for(int n : nums) if(n < pivot) result[j++] = n;
        for(int n : nums) if(n == pivot) result[j++] = n;
        for(int n : nums) if(n > pivot) result[j++] = n;
        return result;
    }
}