class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtLeast(word,k) - countAtLeast(word,k+1);
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    } 

    private long countAtLeast(String word,int k){
        int n = word.length();
        // if(n < k+5) return 0;
        long result = 0;
        int p1 = 0,p2 = 0;
        int consonant = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(p2<n){
            char c = word.charAt(p2);
            if(isVowel(c)){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            else{
                consonant++;
            }
            while(map.size() == 5 && consonant >= k){
                char nc = word.charAt(p1);
                result += n - p2;
                if(isVowel(nc)){
                    map.put(nc,map.get(nc)-1);
                    if(map.get(nc) == 0) map.remove(nc);
                }
                else{
                    consonant--;
                }
                p1++;
            }
            p2++;
        }
        return result;
    }
}