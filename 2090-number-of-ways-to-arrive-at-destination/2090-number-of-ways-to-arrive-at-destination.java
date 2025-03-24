class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        for(int i = 0;i<n;i++) graph[i] = new ArrayList<>();

        for(int[] road: roads){
            int u = road[0], v = road[1], w = road[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0,0});
        long[] dist = new long[n];
        int[] ways = new int[n];
        ways[0] = 1;
        int mod = 1_000_000_007;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if(d > dist[node]) continue;

            for(int[] neigh : graph[node]){
                int next = neigh[0];
                int time = neigh[1];
                if(time + dist[node] < dist[next]){
                    dist[next] = time+dist[node];
                    ways[next] = ways[node];
                    pq.offer(new long[]{next,dist[next]});
                }
                else if(time + dist[node] == dist[next]) ways[next] = (ways[next] + ways[node]) % mod;
            }
        }
        return ways[n-1];
    }
}