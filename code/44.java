class Solution {
    public int findNthDigit(int n) {
        if(n==0)
            return 0;
        //数字的长度为len; 从长度为1的数字开始, 也就是从个位数开始
        int len = 1;
        //长度为len的数字有count个
        long count = 9;
        //长度为len的第一个数字
        int start = 1;
        //确定第n位对应的数字的长度
        while(n > len*count){
            // n = n - len*count; //这么写会报错, 需要把count转成int
            n -= len*count; //这么写就不报错了
            //update
            len++;
            start = start*10;
            count = count*10;
        }
        //确定第n位对应的数字是哪个长度为len的数字
        start = start + (n%len==0? n/len-1 : n/len);
        //取出该数字的第(n-1)%len位
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt(n%len==0? len-1 : n%len-1));
    }
}