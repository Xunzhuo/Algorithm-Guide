class Solution {
    public int nthUglyNumber(int n) {
        int count1=0,count2=0,count3=0;

        int ugly[] = new int[n];

        int i=1;

        if(n==0)

        {
            return 0;

        }

        ugly[0]=1;

        while(i<n)

        {
            int min = Math.min(ugly[count1]*2,ugly[count2]*3);

            min = Math.min(min,ugly[count3]*5);

            ugly[i] = min;

            if(ugly[count1]*2==ugly[i])

            {
                ++count1;

            }

            if(ugly[count2]*3==ugly[i])

            {
                ++count2;

            }

            if(ugly[count3]*5==ugly[i])

            {
                ++count3;

            }

            //  System.out.print(ugly[i]+" ");

            ++i;

        }

        return ugly[i-1];

    }

}