class Solution {
    int mod = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        while(t >= 26){
            int[] temp = new int[26];
            for(int i = 0;i<25;i++){
                temp[i+1] = (temp[i+1]+freq[i])%mod;
                temp[i] = (temp[i]+freq[i])%mod;
            }
            temp[25] = (temp[25]+freq[25])%mod;
            temp[0] = (temp[0]+freq[25])%mod;
            temp[1] = (temp[1]+freq[25])%mod;
            freq = temp;
            t -= 26;
        }
        long result= 0;
        for(int i = 0;i<26;i++){
            int d = 26-i;
            if(t >= d){
                freq[i] = (2*freq[i])%mod;
            }
            result = (result+freq[i])%mod;
        }
        return (int)result;
    }
}