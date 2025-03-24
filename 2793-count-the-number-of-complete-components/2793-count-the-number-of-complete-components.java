class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        List<Integer>[] adj =  new List[n];
        for(int i = 0;i<n;i++) adj[i] = new ArrayList<>();
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph[u][v] = graph[v][u] = true;
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int k = 0;k<n;k++){
            if(visited[k]) continue;
            if(adj[k].size() == 0){
                result++;
                continue;
            } 
            List<Integer> tempVisited = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(k);
            visited[k] = true;
            tempVisited.add(k);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next : adj[curr]){
                    if(!visited[next]){
                        tempVisited.add(next);
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            boolean flag = true;
            for(int i = 0;i<tempVisited.size();i++){
                int u = tempVisited.get(i);
                for(int j = i+1;j<tempVisited.size();j++){
                    int v = tempVisited.get(j);
                    if(!graph[u][v]){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) result++;
        }
        return result;
    }
}