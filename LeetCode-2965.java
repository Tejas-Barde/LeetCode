class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        boolean[] map = new boolean[grid.length*grid.length];
        int[] result = new int[2];
        for(int[] row : grid){
            for(int e : row){
                if(map[e-1]) result[0] = e;
                map[e-1] = true;
            }
        } 
        for(int i = 0;i<map.length;i++){
            if(!map[i]){
                result[1] = i+1;
                break;
            }
        } 
        return result;
    }
}