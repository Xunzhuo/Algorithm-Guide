class Solution {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++){
            res[i] = (res[i - 1] + res[i - 2]) % 1000000007;
        }
        return res[n];
    }
}