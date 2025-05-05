class Solution {
    final long mod = 1000000007;

    public int numTilings(int n) {
        return (int)dominoes(0, n, false);
    }

    private long dominoes(int i, int n, boolean possible) {
        if (i == n) return possible ? 0 : 1;
        if (i > n) return 0;

        if (possible) {
            return (dominoes(i + 1, n, false) + dominoes(i + 1, n, true)) % mod;
        }

        return (dominoes(i + 1, n, false)
              + dominoes(i + 2, n, false)
              + 2 * dominoes(i + 2, n, true)) % mod;
    }
}