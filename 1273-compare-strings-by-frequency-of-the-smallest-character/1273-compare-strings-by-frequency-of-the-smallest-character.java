class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = words.length;
        int top = 0;
        int[] farr = new int[n];
        for (String word : words)
            farr[top++] = f(word);
        Arrays.sort(farr);
        top = 0;
        int[] result = new int[queries.length];
        for (String q : queries) {
            int f = f(q);
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f >= farr[mid])
                    left = mid + 1;
                else
                    right = mid;
            }
            result[top++] = n - left;
        }
        return result;
    }

    private int f(String s) {
        char minChar = 'z';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                count = 1;
            } else if (c == minChar) {
                count++;
            }
        }
        return count;
    }

}