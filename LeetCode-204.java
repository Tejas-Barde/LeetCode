class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] sieve = new boolean[n];
        sieve[0] = sieve[1] = true;
        int result = 0;
        int i = 2;
        while(i*i < n){
            if(!sieve[i]){
                for(int j = i*i;j<n;j += i) sieve[j] = true;
            }
            i++;
        }
        for(boolean s : sieve){
            if(!s) result++;
        }
        return result;
    }

}