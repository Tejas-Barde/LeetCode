class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l3 = s3.length();
        if(m + n != l3) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1;i<m+1;i++)
            if((s1.charAt(i-1) == s3.charAt(i-1)) && dp[i-1][0]) 
                dp[i][0] = true;
        for(int j = 1;j<n+1;j++) 
            if((s2.charAt(j-1) == s3.charAt(j-1)) && dp[0][j-1]) 
                dp[0][j] = true;

        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[m][n];
    }
}