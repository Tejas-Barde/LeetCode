class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Integer>[] diagonals = new PriorityQueue[m+n-1];
        for(int i = 0;i<diagonals.length;i++) diagonals[i] = new PriorityQueue<>();
        for(int i = 0;i<m;i++){
            int top = i;
            for(int j = n-1;j>=0;j--){
                diagonals[top++].offer(mat[i][j]);
            }
        }
        // for(int i = 0;i<diagonals.length;i++){
        //     for(int e : diagonals[i]){
        //         System.out.print(e+" ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0;i<m;i++){
            int top = i;
            for(int j = n-1;j>=0;j--){
                mat[i][j] = diagonals[top++].poll();
            }
        }
        return mat;
    }
}