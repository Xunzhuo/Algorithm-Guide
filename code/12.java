class Solution {
    public int cuttingRope(int n) {
        if(n==2)

        {
            return 1;

        }

        if(n==3)

        {
            return 2;

        }

        int count1=0,count2=0;

        count1 = n/3;

        if(n-count1*3==1&&count1>0)

        {
            count1-=1;

        }

        count2 = n-count1*3;

        count2 /=2;

        int result = 1;

        for(int i=1;i<=count1;i++)

        {
            result*=3;

        }

        for(int i=1;i<=count2;i++)

        {
            result*=2;

        }

        return result;

    }

}