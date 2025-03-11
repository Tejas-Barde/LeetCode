class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int right = 0,left = 0;
        int result = 0;
        while(right < n){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size() == 3){
                while(map.size() == 3){
                    result += n-right;
                    char lc = s.charAt(left);
                    map.put(lc,map.get(lc)-1);
                    if(map.get(lc) == 0) map.remove(lc);
                    left++;
                }
                // System.out.println(left-1);
                // System.out.println(result);
            }
            right++;
        }
        return result;
    }
}