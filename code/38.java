class Solution {
    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();

        boolean visited[] = new boolean[s.length()];

        char arr[] = s.toCharArray();

        Arrays.sort(arr);

        StringBuilder x = new StringBuilder();

        helper(result,visited,arr,x);

        String res[] = new String[result.size()];

        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);

        }

        return res;

    }

    public void helper(List<String> result,boolean visited[],char arr[],StringBuilder x){
        if(x.length()==arr.length){
            result.add(x.toString());

            return;

        }

        for(int i=0;i<arr.length;i++){
            if(i!=0&&arr[i]==arr[i-1]&&visited[i-1]) continue;

            if(!visited[i]){
                x.append(arr[i]);

                visited[i] = true;

                helper(result,visited,arr,x);

                x.deleteCharAt(x.length()-1);

                visited[i] = false;

            }

        }

    }

}