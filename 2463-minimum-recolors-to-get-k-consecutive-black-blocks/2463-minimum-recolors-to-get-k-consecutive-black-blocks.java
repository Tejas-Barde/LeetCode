class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wcount = 0;
        int i = 0 , j = k-1;
        int result;
        for(int p = 0;p<k;p++){
            if(blocks.charAt(p) == 'W'){
                wcount++;
            } 
        } 
        result = wcount;
        while(j < blocks.length()-1){
            if(blocks.charAt(j+1) != blocks.charAt(i)){
                if(blocks.charAt(j+1) == 'W') wcount++;
                else {
                    wcount--;
                    if(wcount == 0) return 0;
                }
            }
            result = Math.min(result,wcount);
            i++;
            j++;
            
        }
        return result;
    }
}