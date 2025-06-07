class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        int fact = 1;
        for (int i = 1; i < n; i++) fact *= i;  
        k = k - 1;
        StringBuilder sb = new StringBuilder();

        while (nums.size() > 0) {
            int index = k / fact;
            sb.append(nums.get(index));
            nums.remove(index);

            if (nums.size() == 0) break;

            k %= fact;
            fact /= nums.size();
        }

        return sb.toString();
    }
}
