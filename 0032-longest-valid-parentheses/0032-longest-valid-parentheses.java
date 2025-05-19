class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty() || s.charAt(stack.peek()) == ')'){
                    stack.push(i);
                    continue;
                } 
                stack.pop();
                int length ;
                if(stack.isEmpty()) length = i+1;
                else length = i - stack.peek(); 
                result = Math.max(length,result);
            }
        }   
        return result;
    }
}

