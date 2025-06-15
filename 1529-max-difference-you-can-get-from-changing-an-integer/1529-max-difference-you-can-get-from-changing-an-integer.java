class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                StringBuilder replaced = new StringBuilder();
                for (char c : str.toCharArray()) {
                    if (c - '0' == x) {
                        replaced.append((char) ('0' + y));
                    } else {
                        replaced.append(c);
                    }
                }

                // Skip invalid numbers (leading 0s or 0 itself)
                if (replaced.charAt(0) == '0') continue;

                int val = Integer.parseInt(replaced.toString());
                max = Math.max(max, val);
                min = Math.min(min, val);
            }
        }
        return max - min;
    }
}
