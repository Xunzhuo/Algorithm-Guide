class Solution {
    public int[] constructArr(int[] a) {


        int left[] = new int[a.length];

        int right[] = new int[a.length];

        int result[] = new int[a.length];

        if(a.length==0)

        {
            return result;

        }

        left[0] = 1;

        right[a.length-1]=1;

        for(int i =1;i<a.length;i++)

        {
            left[i] = left[i-1]*a[i-1];

        }

        for(int i = a.length-2;i>=0;i--)

        {
            right[i] = right[i+1]*a[i+1];

        }

        for(int i=0;i<a.length;i++)

        {
            result[i] = left[i]*right[i];

        }

        return result;

    }

}