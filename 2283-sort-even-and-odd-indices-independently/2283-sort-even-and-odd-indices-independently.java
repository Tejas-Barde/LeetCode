import java.util.Arrays;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int evenSize = (n + 1) / 2;
        int oddSize = n / 2;

        int[] even = new int[evenSize];
        int[] odd = new int[ oddSize];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                even[i / 2] = nums[i];
            else
                odd[i / 2] = nums[i];
        }
        Arrays.sort(even); // ascending
        Arrays.sort(odd);  // ascending

        for (int i = 0, ei = 0, oi = odd.length - 1; i < n; i++) {
            if (i % 2 == 0)
                nums[i] = even[ei++];
            else
                nums[i] = odd[oi--];
        }
        return nums;
    }
}