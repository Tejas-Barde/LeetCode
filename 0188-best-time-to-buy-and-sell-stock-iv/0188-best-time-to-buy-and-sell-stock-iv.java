class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        Arrays.fill(buy,Integer.MAX_VALUE);
        int[] sell = new int[k];
        for(int i = 0;i<prices.length;i++){
            buy[0] = Math.min(buy[0],prices[i]);
            sell[0] = Math.max(sell[0],prices[i] - buy[0]);
            for(int j = 1;j<k;j++){
                buy[j] = Math.min(buy[j],prices[i]-sell[j-1]);
                sell[j] = Math.max(sell[j],prices[i]-buy[j]);
            }
        }

        return sell[k-1];
    }
}