class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);          
        visited[0] = true;     
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int room : rooms.get(curr)) {
                if (!visited[room]) {
                    visited[room] = true;
                    que.offer(room);
                }
            }
        }
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }
}