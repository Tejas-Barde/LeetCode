class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int small = 0;
        int count = 0;
        for(int num : nums){
            if(num < target) small++;
            if(num == target) count++;
        } 
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<count;i++){
            result.add(i+small);
        }
        return result;
    }
}