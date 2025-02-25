class Solution {
    public int numOfSubarrays(int[] arr) {
        long prefixSum = 0;
        int even = 1;
        int odd = 0;
        long result = 0;
        for(int n : arr){
            prefixSum = (prefixSum + n) % 1_000_000_007;
            if(prefixSum % 2 != 0){
                odd++;
                result += even;
            }
            else{
                even++;
                result += odd;
            }
        }
        return (int) (result % 1_000_000_007);
    }
}