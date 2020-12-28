class Solution {
    public char firstUniqChar(String s) {
        int arr[] = new int[26];

        for(int i=0;i<s.length();i++)

        {
            arr[s.charAt(i)-'a']++;

        }

        for(int i=0;i<s.length();i++)

        {
            if(arr[s.charAt(i)-'a']==1)

            {
                return s.charAt(i);

            }

        }

        return ' ';

    }

}