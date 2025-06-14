class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double[][] search = new double[n*(n+1)/2][];
        int top = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                search[top++] = new double[]{(double)arr[i]/arr[j],arr[i],arr[j]};
            }
        }
        Arrays.sort(search,(double[] a,double[] b)->{
            if(a[0] > b[0]) return 1;
            return -1;
        });
        // for(double[] s : search){
        //     System.out.println(s[0]+" "+s[1]+" "+s[2]);
        // }
        int[] result = new int[2];
        result[0] = (int)search[k-1][1];
        result[1] = (int)search[k-1][2];
        return result;
    }
}