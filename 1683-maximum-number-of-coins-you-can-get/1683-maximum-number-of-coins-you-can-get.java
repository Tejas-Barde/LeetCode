class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int result= 0;
        int q = n/3;
        for(int i = n-2;i>=0;i-=2){
            if(q-- == 0) break;
            // System.out.println(piles[i]);
            result += piles[i];
        }
        return result;
    }
}