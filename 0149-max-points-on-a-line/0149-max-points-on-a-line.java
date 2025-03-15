class Solution {
    public int maxPoints(int[][] points) {
        int m = points.length;
        if(m <= 2) return m;
        int result = 0;
        for(int i = 0;i<m;i++){
            for(int j = i+1;j<m;j++){
                int count = 2;
                for(int k = j+1;k<m;k++){
                    if((points[j][0]-points[k][0])*(points[i][1]-points[j][1]) == (points[j][1]-points[k][1])*(points[i][0]-points[j][0])) count++;
                    if(count+m-k < result) break;
                }
                result = Math.max(result,count);  
            }
        }
        return result;
    }   

}