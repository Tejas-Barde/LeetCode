class Solution {
    public int minMaxDifference(int num) {
        int max = 0,min = 0;
        String str = Integer.toString(num);
        char rmax = str.charAt(0);
        char rmin = str.charAt(0);
        for(char c : str.toCharArray()){
            if(rmin == '0'){
                rmin = c;
                min = min*10;
            } 
            else{
                if(rmin == c) min = min*10;
                else min = min*10+c-'0';
            }
            if(rmax == '9'){
                max = max*10+9;
                rmax = c;
            } 
            else{
                if(rmax == c) max = max*10 + 9;
                else max = max*10+c-'0';
            }
        }
        // System.out.println(max+" "+min);
        return max-min;
    }
}