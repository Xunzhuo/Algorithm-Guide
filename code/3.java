class Solution {
    public String replaceSpace(String s) {
        if(s.length()==0)

        {
            return s;

        }

        StringBuilder x = new StringBuilder();

        for(int i=0;i<s.length();i++)

        {
            if(s.charAt(i)!=' ')

            {
                x.append(s.charAt(i));

            }

            else

            {
                x.append("%20");

            }

        }

        return x.toString();

    }
}