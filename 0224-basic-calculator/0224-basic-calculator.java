class Solution {
    public int calculate(String s) {
        int i = 0;
        int sign = 1;
        int num = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){

                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                num *= sign;
                ans += num;
                sign = 1;
                num = 0;
            }
            else if(c == '+') sign = 1;
            else if(c == '-') sign = -1;
            else if(c == '('){
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            }
            else if(c == ')'){
                ans *= stack.pop(); // multiply the sign
                ans += stack.pop(); // add the previous ans
            }
            i++;
        }
        return ans;
    }
}