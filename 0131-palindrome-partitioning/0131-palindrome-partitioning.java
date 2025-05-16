class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>());
        return result;
    }

    private void backtrack(String s,int top,List<String> temp){
        if(s.length() == top){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = top;i<s.length();i++){
            if(isPalindrome(s,top,i)){  
                temp.add(s.substring(top,i+1));
                backtrack(s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}