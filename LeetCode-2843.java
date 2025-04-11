class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        while(low <= high){
            String str = String.valueOf(low);
            if(str.length()%2 == 0){
                int startSum = 0 , endSum = 0;
                int start = 0,end = str.length()-1;
                while(start < end){
                    startSum += str.charAt(start++);
                    endSum += str.charAt(end--);
                }
                if(startSum == endSum) result++;
            }
            low++;
        }
        return result;
    }
}