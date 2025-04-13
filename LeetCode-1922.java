class Solution {
    int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        return (int)((multiply(4,n/2) * multiply(5,(n+1)/2))%MOD);
    }

    private long multiply(long base,long exp){
        long result = 1;
        while(exp > 0){
            if(exp % 2 == 0){
                exp /= 2;
                base = (base * base)%MOD;
            }
            else {
                exp--;
                result = (result*base)%MOD;
            }
        }
        return result;
    }
}