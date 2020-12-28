class Solution {
    public String reverseLeftWords(String s, int n) {
        if(n>s.length()-1||n<=0)

        {
            return s;

        }

        String x = s.substring(0,n);

        s = s.substring(n,s.length());

        return s+x;

    }

}