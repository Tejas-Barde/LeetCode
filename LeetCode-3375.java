class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] visited = new boolean[101];
        for(int n : nums){
            if(n < k) return -1;
            if(n > k) visited[n] = true;
        }
        int result = 0;
        for(boolean v : visited) if(v) result++;
        return result;
    }
}