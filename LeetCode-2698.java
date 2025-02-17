import java.util.*;

class Solution {
    List<Integer> nums = new ArrayList<>();
    public int punishmentNumber(int n) {
        int result = 0;
        int i = 0;
        for(i = 0;i<nums.size();i++) result += nums.get(i) * nums.get(i);
        if(i != 0) i = nums.get(nums.size()-1);
        for(;i<=n;i++){
            if(isValid(i*i,i)){
                nums.add(i);
                result += i*i;
            } 
        }
        return result;
    }

    private boolean isValid(int n,int target ){
        if(n == target) return true;
        if(n == 0) return false;
        for(int i = 10;i<= n;i *= 10){
            if(isValid(n/i, target - n%i)) return true;
        }
        return false;
    }
}