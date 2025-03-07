class Solution {
    public int[] closestPrimes(int left, int right) {
        if(left <= 2){
            if(right >2) return new int[]{2,3};
            return new int[]{-1,-1};
        }
        int prev = 0 , curr = 0;
        int[] result = new int[2];
        int min = Integer.MAX_VALUE ;
        int i = (left%2 == 0)?left+1:left;
        for( ; i < right;i += 2 ){
            if(isPrime(i)){
                prev = i;
                break;
            }
        }
        for( ; i <= right;i += 2){
            if(isPrime(i)){
                prev = curr;
                curr = i;
                if(curr - prev == 1) return new int[]{prev,curr};
                else if(curr - prev < min){
                    result[0] = prev;
                    result[1] = curr;
                    min = curr-prev;
                } 
            } 
        }
        if(curr == 0 || prev == 0) return new int[]{-1,-1};
        return result;
    }

    private boolean isPrime(int n){
        for(int i = 3;i<= Math.pow(n,0.5);i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}