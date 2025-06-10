class Solution {
    public int maxDifference(String s) {
        int[] diff = new int[26];
        int max = 0;
        int min = s.length();
        for(int i= 0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            diff[idx]++;
        }
        for(int d : diff){
            if(d == 0) continue;
            if(d%2 == 0) min = Math.min(min,d);
            else max = Math.max(max,d);
        }
        return max-min;
    }
}