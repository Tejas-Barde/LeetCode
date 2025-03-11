class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<9;i += 3){
            for(int j = 0;j<9;j += 3){
                if(!isValidGrid(board,i,j)) return false;
            }
        }
        for(int i = 0;i<9;i++){
            boolean[] visited = new boolean[10];
            for(int j=0;j<9;j++){   
                if(board[i][j] != '.'){
                    int idx = board[i][j] - '0';
                    if(visited[idx]) return false;
                    visited[idx] = true;
                }
            }
        }
        for(int i = 0;i<9;i++){
            boolean[] visited = new boolean[10];
            for(int j=0;j<9;j++){   
                if(board[j][i] != '.'){
                    int idx = board[j][i] - '0';
                    if(visited[idx]) return false;
                    visited[idx] = true;
                }
            }
        }
        return true;
    }
    
    private boolean isValidGrid(char[][] board,int r,int c){
        boolean[] visited = new boolean[10];
        for(int i = r;i<r+3;i++){
            for(int j = c;j<c+3;j++){
                if(board[i][j] != '.'){
                    int idx = board[i][j] - '0';
                    if(visited[idx]) return false;
                    visited[idx] = true;
                }               
            }
        }
        return true;
    }
}