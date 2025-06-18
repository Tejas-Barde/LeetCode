class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
        int[] result2 = new int[n];
        prefix[0] = boxes.charAt(0)-'0';
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] + boxes.charAt(i)-'0';
            result[i] = prefix[i-1]+result[i-1];
        }
        // for(int r : result) System.out.print(r + " ");
        // System.out.println();
        suffix[n-1] = boxes.charAt(n-1)-'0';
        for(int i = n-2;i>=0;i--){
            suffix[i] = suffix[i+1] + boxes.charAt(i)-'0';
            result2[i] = suffix[i+1]+result2[i+1];
            result[i] += result2[i];
        }
        return result;
    }
}