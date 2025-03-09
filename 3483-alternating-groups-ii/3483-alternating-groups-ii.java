class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        boolean flag = true; // to check if all the colors are alternate
        int result = 0;
        for(int i = 0;i<n;i++){
            if(i == n-1){
                if(colors[0] == colors[i]){
                    // System.out.println(i);
                    result += getAlternatingGroup(colors,i,k);
                    flag = false;
                }
                continue;
            }
            if(colors[i] == colors[i+1]){
                result += getAlternatingGroup(colors,i,k);
                flag = false;
            }
        }
        // System.out.println(flag);
        if(flag) return n;
        return result;
    }

    private int getAlternatingGroup(int[] colors,int i,int k){
        int count = 0;
        int n = colors.length;
        int j = (i+1)%n;
        do{
            if(colors[j] != colors[(j+1)%n]){
                k--;
                if(k <= 1) count++;
            } 
            else break;
            j = (j+1)%n;
            // System.out.println(j+" "+k+" "+count);
        }while(j != (i+1)%n);
        return count;
    }
}