class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = costs[0];
        for(int cost : costs) max = Math.max(cost,max);
        int[] freq = new int[max+1];
        for(int cost : costs) freq[cost]++;
        int result = 0;
        for(int i = 1;i<max+1;i++){
            int temp = i*freq[i];
            if(temp <= coins){
                result += freq[i];
                coins -= temp;
            } 
            else{
                result += (coins/i);
                coins -= ((coins/i)*i);
            }
            if(coins == 0) return result;
        }
        return result;
    }
}