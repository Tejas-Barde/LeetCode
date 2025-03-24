class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] map = new int[3];
        int right = 0,left = 0;
        int result = 0;
        int size = 0;
        while(right < n){
            char c = s.charAt(right);
            if(map[c-'a']++ == 0) size++;
            while(size == 3){
                result += n-right;
                char lc = s.charAt(left);
                map[lc-'a']--;
                size = (map[lc-'a'] == 0)?size-1:size;
                left++;
            }
            right++;
        }
        return result;
    }
}