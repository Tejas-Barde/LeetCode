class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1, right = position[n-1]-position[0];
        while(left < right){
            int mid = left + (right-left)/2;
            // System.out.println("mid - "+mid);
            int count = 1;
            int prev = 0;
            for(int i = 1;i<n;i++){
                if(position[i] - position[prev] > mid){
                    prev = i;
                    count++;
                }
            }
            // System.out.println(count);
            if(count+1 > m) left = mid+1;
            else right = mid;
        }
        return left;
    }
}