class Solution {
    int[] power = new int[17];
    public Solution(){
        for(int i = 0;i<=16; i++){
            power[i] = (int)Math.pow(3,i);
        }
    }
    public boolean checkPowersOfThree(int n) {
        for(int i = 16;i>=0;i--) if(power[i] <= n) n -= power[i];
        return (n == 0)?true:false;
    }
}