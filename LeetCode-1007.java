class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] swap = new int[2][2];
        swap[0][1] = swap[1][1] = 1;
        for(int i= 1;i<tops.length;i++){
            if(tops[0] != tops[i] && bottoms[i] != tops[0]) swap[0][0] = swap[0][1] = tops.length+1;
            else if(tops[0] == tops[i] && tops[0] == bottoms[i]){}
            else if(tops[0] == bottoms[i]) swap[0][0]++;
            else swap[0][1]++;
            
            if(bottoms[0] != tops[i] && bottoms[i] != bottoms[0]) swap[1][0] = swap[1][1] = tops.length+1;
            else if(bottoms[0] == tops[i] && bottoms[0] == bottoms[i]){}
            else if(bottoms[0] == tops[i]) swap[1][0]++;
            else swap[1][1]++;
        }
        int result =  Math.min(Math.min(swap[0][0],swap[0][1]),Math.min(swap[1][0],swap[1][1]));
        if(result > tops.length) return -1;
        return result;
    }
}