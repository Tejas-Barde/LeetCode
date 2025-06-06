class Solution {
    public String robotWithString(String s) {
        int[] map = new int[26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            map[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        char small = 'a';
       
        for(int top=0;top < s.length();top++){
            char curr = s.charAt(top);
            
            if(curr == small) result.append(curr);
            else stack.push(curr);
            
            map[curr-'a']--;
            while(small <= 'z' && map[small-'a']==0) small++;
            
            while(!stack.isEmpty() && stack.peek()<=small){
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
}
