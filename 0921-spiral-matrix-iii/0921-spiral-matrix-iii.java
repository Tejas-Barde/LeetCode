class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] direction = new int[][]{
            {0,1},{1,0},{0,-1},{-1,0}
        };
        int[][] result = new int[rows*cols][2];
        int top = 0;
        int dir = 0;
        int r = rStart;
        int c = cStart;
        result[top++] = new int[]{r, c};
        int steps = 1;
        while(top < rows*cols){
            for(int i = 0;i<2;i++){
                for(int s = 0;s<steps;s++){
                    r += direction[dir][0];
                    c += direction[dir][1];
                    if(r > -1 && c > -1 && r < rows && c < cols) 
                        result[top++] = new int[]{r,c};
                }
                dir = (dir+1)%4;
            }
            steps++;
        }
        return result;
    }
}