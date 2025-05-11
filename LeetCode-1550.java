class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int a : arr){
            if(a%2 != 0) {
                if(++count == 3) return true;
            }
            else count = 0;
        }
        return false;
    }
}