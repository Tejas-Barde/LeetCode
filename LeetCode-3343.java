class Solution {
    int mod = 1_000_000_007;
    long[] factorial, invFact ,inv;
    public int countBalancedPermutations(String num) {
        int totalSum = 0;
        for(char c : num.toCharArray()){
            totalSum += c-'0';
        }
        if(totalSum % 2 != 0) return 0;
        compute(num.length());
        int halfSum = totalSum/2;
        int halfLen = num.length()/2;
        int[] freq = new int[10];
        int[][] dp = new int[halfSum+1][halfLen+1];
        dp[0][0] = 1;
        for(char c : num.toCharArray()){
            int digit = c-'0';            
            freq[digit]++;
            for(int sum = halfSum;sum>=digit;sum--){
                for(int len = halfLen;len>0;len--){
                    dp[sum][len] = (dp[sum][len] + dp[sum-digit][len-1])%mod;
                }
            }
        }
        long result = dp[halfSum][halfLen];
        result  = result * factorial[halfLen] % mod * factorial[num.length()-halfLen] % mod;
        for(int f : freq) result = result * invFact[f] % mod;
        return (int) result;
    }

    private void compute(int n){
        factorial = new long[n+1];
        invFact = new long[n+1];
        inv = new long[n+1];
        factorial[0] = invFact[0] = inv[0] = 1;
        for(int i = 1;i<=n;i++) factorial[i] = (factorial[i-1]*i)%mod;
        inv[1] = 1;
        for(int i = 2;i<=n;i++) inv[i] = mod - (mod / i) * inv[mod % i] % mod;
        for(int i = 1;i<=n;i++) invFact[i] = (invFact[i-1]*inv[i])%mod;
    }
}