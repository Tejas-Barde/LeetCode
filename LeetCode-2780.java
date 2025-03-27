import java.util.List;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int count = 1;
        int length = nums.size();
        int dominant = nums.get(0);
        for(int i = 1;i<length;i++){
            if(nums.get(i) == dominant) count++;
            else {
                if(--count == 0){
                    dominant = nums.get(i);
                    count = 1;
                }
            }
        }
        int maxCount = 0;
        for(int n : nums) if(n == dominant) maxCount++; 
        count = 0;
        for(int i = 0;i<length;i++){
            if(nums.get(i) == dominant) count++;
            if(count*2 >(i+1) && ((maxCount-count)*2 > (length-i-1))) return i;
        }
        return -1;
    }
}