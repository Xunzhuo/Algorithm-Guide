class Solution {
    public int translateNum(int num) {
        if(num<0)

        {
            return 0;

        }

        if(num<10)

        {
            return 1;

        }

        int n=num,k=0;

        while(n!=0)

        {
            k++;

            n/=10;

        }

        k--;

        int dp[] = new int[k+1];

        dp[0]=1;

        StringBuilder sb = new StringBuilder();

        for(int i=k;i>=0;i--)

        {
            int x = (int)((num/Math.pow(10,i))%10);

            //  System.out.println(x);

            sb.append(x);

        }

        //System.out.println(k+" "+sb);

        if(k>=1)

        {
            if(sb.charAt(0)=='1'||(sb.charAt(0)=='2'&&sb.charAt(1)<'6'))

                dp[1]=2;

            else

                dp[1]=1;

        }

        else

        {
            dp[1] = 1;

        }

        for(int i=2;i<=k;i++)

        {
            if(i>1)

            {
                if(sb.charAt(i-1)=='0'||sb.charAt(i-1)>'2')

                {
                    dp[i] = dp[i-1];

                }

                else if(sb.charAt(i-1)=='2'&&sb.charAt(i)>='6')

                {
                    dp[i] = dp[i-1];

                }

                else

                {
                    dp[i] = dp[i-2]+dp[i-1];

                }

            }

        }

        return dp[k];

    }

}