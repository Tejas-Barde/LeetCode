class Solution {
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        int n = s.length();
        
        if (n < 4 || n > 12) return result;

        for (int i = 1; i < Math.min(4, n - 2); i++) {
            for (int j = i + 1; j < Math.min(i + 4, n - 1); j++) {
                for (int k = j + 1; k < Math.min(j + 4, n); k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        result.add(String.join(".", a, b, c, d));
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}
