class Solution {
    public String minNumber(int[] nums) {
        if(nums==null||nums.length==0)

        {
            return " ";

        }

        List<Integer> list = new LinkedList<>();

        for(int i=0;i<nums.length;i++)

        {
            list.add(nums[i]);

        }

        Collections.sort(list,new Comparator<Integer>(){
            @Override

            public int compare(Integer o1,Integer o2)

            {
                String s1 = o1+"" +o2;

                String s2 = o2+""+o2;

                return s1.compareTo(s2);

            }

        });

        StringBuilder result = new StringBuilder();

        for(int i:list)

        {
            result.append(i);

        }

        return result.toString();

    }

}