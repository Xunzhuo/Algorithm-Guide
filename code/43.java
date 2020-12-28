class Solution {
    private int dfs(int n) {
        if (n <= 0) {
            return 0;

        }



        String numStr = String.valueOf(n);

        int high = numStr.charAt(0) - '0';

        int pow = (int) Math.pow(10, numStr.length() - 1);

        int last = n - high * pow;



        if (high == 1) {
            // 最高位是1，如1234, 此时pow = 1000,那么结果由以下三部分构成：

            // (1) dfs(pow - 1)代表[0,999]中1的个数;

            // (2) dfs(last)代表234中1出现的个数;

            // (3) last+1代表固定高位1有多少种情况。

            return dfs(pow - 1) + dfs(last) + last + 1;

        } else {
            // 最高位不为1，如2234，那么结果也分成以下三部分构成：

            // (1) pow代表固定高位1，有多少种情况;

            // (2) high * dfs(pow - 1)代表999以内和1999以内低三位1出现的个数;

            // (3) dfs(last)同上。

            return pow + high * dfs(pow - 1) + dfs(last);

        }

    }



    // 递归求解

    public int countDigitOne(int n) {
        return dfs(n);

    }

}