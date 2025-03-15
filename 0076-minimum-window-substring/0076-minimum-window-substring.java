class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        int left = 0,right = 0;
        int n = s.length();
        int tl = t.length();
        Map<Character,Integer> temp = new HashMap<>();
        int start = -1,end = n;
        int count = 0;
        while(right < n){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                temp.put(c,temp.getOrDefault(c,0)+1);
                count = (temp.get(c) <= map.get(c))?count+1:count;
                if(count == tl){
                    while(count == tl){
                        char nc = s.charAt(left);
                        if(map.containsKey(nc)){
                            temp.put(nc,temp.get(nc)-1);
                            if(temp.get(nc) < map.get(nc)) count--;
                        }
                        left++;
                    }
                    if(end - start > right+1 - left+1) {
                        end = right+1;
                        start = left-1;
                    }
                }
            } 
            right++;
        }
        return (start == -1)?"":new String(s.substring(start,end));
    }
}