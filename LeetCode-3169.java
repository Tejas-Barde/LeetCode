import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int max = 0;
        int result = 0;
        for(int[] meet : meetings){
            if(meet[0]>max) result += meet[0]-max-1;
            max = Math.max(max,meet[1]);
        }
        result += days-max;
        return result;
    }
}