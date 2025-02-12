class Solution {
    public int maximumSum(int[] nums) {
        int[] map = new int[100];
        int maxSum = -1;
        for(int n : nums){
            int digitSum = 0;
            int t = n;
            while(t > 0){
                digitSum += t%10;
                t /= 10;
            }
            if(map[digitSum] == 0) map[digitSum] = n;
            else{
                maxSum = Math.max(maxSum,map[digitSum]+n);
                map[digitSum] = Math.max(n,map[digitSum]);
            } 
        }
        return maxSum;
    }
}