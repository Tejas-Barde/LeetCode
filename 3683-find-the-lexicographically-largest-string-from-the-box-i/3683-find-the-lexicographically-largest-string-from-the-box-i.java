class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        int n = word.length();
        String result = "";
        for(int i = 0;i<n;i++){
            String temp;
            if(i+n-numFriends+1 <= n) temp = word.substring(i,i+n-numFriends+1);
            else temp = word.substring(i);
            if(temp.compareTo(result) > 0) result = temp;
        }
        return result;
    }
}