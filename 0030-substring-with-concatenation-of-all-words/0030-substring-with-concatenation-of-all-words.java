class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> hash = new HashMap<>();
        for(String w:words) hash.put(w,hash.getOrDefault(w,0)+1);
        int n = s.length();
        int wl = words[0].length();
        int totalWords = words.length;

        for(int i=0;i<wl;i++){
            Map<String,Integer> temp = new HashMap<>();
            int count = 0;
            for(int j=i,k=i;j+wl<=n;j+=wl){
                String sub = s.substring(j,j+wl);
                temp.put(sub,temp.getOrDefault(sub,0)+1);
                count++;

                if(count == totalWords){
                    if(hash.equals(temp)){
                        result.add(k);
                    }
                    String remove = s.substring(k,k+wl);
                    temp.computeIfPresent(remove,(key,val)->(val>1)?val-1:null);
                    count--;
                    k+=wl;
                }
            }
        }
        return result;
    }
}