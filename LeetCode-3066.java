import java.util.*;
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long n : nums) if(n <= k) pq.offer(n);
        int ans = 0;
        while(!pq.isEmpty()){
            long n1 = pq.poll();
            if(n1 >= k) return ans;
            if(!pq.isEmpty()){
                long n2 = pq.poll();
                pq.offer(Math.min(n1,n2)*2 + Math.max(n1,n2));
                ans++;
            }
        }
        return ans;
    }
}