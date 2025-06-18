class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] result = new int[n];
        result[0] = pref[0];
        int[] prefix = new int[n];
        prefix[0] = pref[0];
        for(int i = 1;i<n;i++){
            result[i] = prefix[i-1] ^ pref[i]; 
            // System.out.println(result[i]);
            prefix[i] = prefix[i-1] ^ result[i];
            // System.out.println(result[i]);
        } 
        return result;
    }
}