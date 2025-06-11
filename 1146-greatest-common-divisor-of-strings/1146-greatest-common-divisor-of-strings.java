class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        int n1 = str1.length();
        int n2 = str2.length();
        if(n1*2 == n2 || n2*2 == n1) return (n1<n2)?str1:str2;
        for(int i = Math.min(n1,n2);i>=0;i--){
            if(n1%i == 0 && n2%i == 0) return str1.substring(0,i);
        }
        return "";
    }
}