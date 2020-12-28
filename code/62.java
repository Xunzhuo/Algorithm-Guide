class Solution {
    public String reverseWords(String s) {
        String x = s.trim();

        char arr[] =  s.toCharArray();

        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++)

        {
            if(arr[i]!=' ')

            {
                sb.append(arr[i]);

            }

            if(i!=arr.length-1)

            {
                if(arr[i]==' '&&arr[i+1]!=' ')

                {
                    String t = sb.toString();

                    list.add(t);

                    sb = new StringBuilder();

                }

            }

            else

            {
                String t = sb.toString();

                list.add(t);

            }

        }

        int k =list.size()-1;

        sb = new StringBuilder();

        while(k>=0)

        {
            sb.append(' ');

            sb.append(list.get(k));

            k--;

        }

        return sb.toString().trim();

    }

}