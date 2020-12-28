class Solution {
    public int add(int a, int b) {
        int sum=0;

        while(b!=0)

        {
            int temp = a^b;

            b = (a&b)<<1;

            a = temp;

        }

        return a;

    }

}