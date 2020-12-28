class Solution {
    public double myPow(double x, int n) {
        int flag = 0;

        if(n==0)

        {
            return 1;

        }

        else if(n<0){
            n=-n;

            flag=1;

        }

        double result = PowCorn(x,n);

        if(flag==1)

        {
            result = 1/result;

        }

        return result;

    }

    public double PowCorn(double x,int n)

    {
        if(n==0)

        {
            return 1;

        }

        double a = PowCorn(x,n/2);

        if(n%2==0)

        {


            return a*a;

        }

        else

        {
            return a*a*x;

        }

    }

}