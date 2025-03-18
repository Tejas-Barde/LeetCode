class Solution {
    public int maxVowels(String s, int k) {
        int vowel = 0, result = 0;
        for(int i = 0;i<s.length();i++){
            if(isVowel(s.charAt(i))) vowel++;
            if(i-k>=0 && isVowel(s.charAt(i-k))) vowel--;
            result = Math.max(result,vowel);
        }
        return result;
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c=='u';
    }
}