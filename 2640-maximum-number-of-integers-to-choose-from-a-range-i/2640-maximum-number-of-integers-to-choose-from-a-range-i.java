class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] map = new boolean[10001];
        for(int b : banned) map[b] = true;
        int result = 0;
        for(int i = 1;i<=n;i++){
            if(map[i]) continue;
            maxSum -= i;
            if(maxSum < 0) return result;
            result++;
        } 
        return result;
    }
}