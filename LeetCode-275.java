class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0, end = n-1;
        while(start <= end){
            int mid = (start+end) >> 1;
            if(citations[mid] >= n - mid) end = mid-1;
            else start = mid+1;
        }

        return n - start;
    }
}