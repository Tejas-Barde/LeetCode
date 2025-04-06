import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        for(int i = nums.length-1;i>=0;i--){
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]%nums[i] == 0){
                    if(dp[i][0] < dp[j][0] + 1){
                        dp[i][0] = dp[j][0]+1;
                        dp[i][1] = j;
                    }
                }
            }
            if(dp[i][1] == 0) dp[i][1] = nums.length;
        }
        int pivot = 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(max < dp[i][0]){
                pivot = i;
                max = dp[i][0];
            }
        }
        List<Integer> result = new ArrayList<>();
        while(pivot < nums.length){
            result.add(nums[pivot]);
            pivot = dp[pivot][1];       
        }
        return result;
    }
}