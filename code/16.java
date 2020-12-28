class Solution {
    public int[] printNumbers(int n) {
        int max=0;
        max= (int)Math.pow(10,n)-1;
        int[] count=new int[max];
        for(int i=1;i<=max;i++){
            count[i-1]=i;
        }
        return count;
    }
}