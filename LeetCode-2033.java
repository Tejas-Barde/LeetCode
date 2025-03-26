import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] values = new int[grid.length*grid[0].length];
        int top = 0;
        for(int[] arr : grid){
            for(int n : arr) values[top++] = n;
        }
        Arrays.sort(values);
        int median = values[(values.length-1)/2];
        int result = 0;
        for(int n : values){
            if((median-n) % x != 0) return -1;
            result += Math.abs(median-n)/x;
        }
        return result;
    }
}