import java.util.Arrays;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles,(a,b)->Integer.compare(a[0],b[0]));
        int max = rectangles[0][0];
        int count = -1;

        for(int[] rect : rectangles){
            if(max <= rect[0]){
                if(++count == 2) return true;
            }
            max = Math.max(max,rect[2]);
        }
        Arrays.sort(rectangles,(a,b)->Integer.compare(a[1],b[1]));
        max = rectangles[0][1];
        count = -1;
        for(int[] rect : rectangles){
            if(max <= rect[1]){
                if(++count == 2) return true;
            }
            max = Math.max(max,rect[3]);
        }
        return false;
    }
}