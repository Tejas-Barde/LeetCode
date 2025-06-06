class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersection(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            if(i == 0 || nums1[i] != nums1[i-1]){
                int l=0 ,r=nums2.length-1;
                while(l <= r){
                    int m=(l+r)>>1;
                    if(nums2[m] < nums1[i]) l = m+1;
                    else if(nums2[m] > nums1[i]) r = m-1;
                    else{
                        list.add(nums1[i]);
                        break;
                    } 
                }
            }
        }
        int[] result = new int[list.size()];
        int top = 0;
        for(int l : list) result[top++] = l;
        return result;
    }
}