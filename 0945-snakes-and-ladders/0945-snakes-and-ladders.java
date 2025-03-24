import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); 

        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n * n) return result;

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int[] pos = getCoordinates(next, n);
                    int r = pos[0], c = pos[1];

                    int nextPos = (board[r][c] == -1) ? next : board[r][c];

                    if (!visited[nextPos]) {
                        visited[nextPos] = true;
                        q.offer(nextPos);
                    }
                }
            }
            result++;
        }
        return -1; 
    }

    private int[] getCoordinates(int num, int n) {
        int r = n - (num - 1) / n - 1; 
        int c = (num - 1) % n;
        if ((n - r) % 2 == 0) { 
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}
