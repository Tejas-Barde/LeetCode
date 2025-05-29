class NumMatrix {
    private int[][] prefixCol;
    // private int[][] prefixRow;
    public NumMatrix(int[][] matrix) {
        prefixCol = new int[matrix.length+1][matrix[0].length];
        // prefixRow = new int[matrix.length][matrix[0].length+1];
        calculatePrefixSum(matrix);
    }

    private void calculatePrefixSum(int[][] matrix){
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                prefixCol[i+1][j] = prefixCol[i][j] + matrix[i][j];
                // prefixRow[i][j+1] = prefixRow[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = col1;i<=col2;i++){
            sum += (prefixCol[row2+1][i] - prefixCol[row1][i]);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */