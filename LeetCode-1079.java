import java.util.*;
class Solution {
    int[] factorial = new int[]{1,1,2,6,24,120,720,5040};
    public int numTilePossibilities(String tiles) {
        Queue<int[][]> q = new LinkedList<>();
        
        int[] map = new int[26];
        int count = 0;
        for(char c : tiles.toCharArray()) if(++map[c-'A'] == 1) count++;

        int[] distinct = new int[count];
        int top = 0;
        for(int i : map) if(i != 0) distinct[top++] = i;
        
        int result = 0;
        q.offer(new int[][]{distinct,{0,tiles.length()}});
        while(!q.isEmpty()){
            int[][] curr = q.poll();
            int[] arr = curr[0];
            System.out.println();
            int length = curr[1][1];
            int i = curr[1][0];
            for(;i<arr.length;i++){
                if(arr[i] > 0){
                    int[] next = arr.clone();
                    next[i]--;
                    q.offer(new int[][]{next,{i,length-1}});
                }
            }
            result += getCombination(arr,length);
        }
        return result-1;
    }

    private int getCombination(int[] arr, int length){
        int combo = factorial[length];
        for(int i : arr) combo /= factorial[i];
        return combo;
    }
}