class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] result = new String[n/k+(n%k == 0?0:1)];
        int top = 0;
        for(int i = 0;i<n;i+=k){
            result[top++] = s.substring(i,Math.min(n,k+i));
        }
        if(result[top-1] == null || result[top-1].length() < k){
            StringBuilder fillStr = new StringBuilder();
            for(int j = result[top-1].length();j<k;j++) fillStr.append(fill);
            result[top-1] += fillStr.toString();
        }
        return result;
    }
}