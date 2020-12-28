/*
核心: 有效数字的模式有两种:1)A[.[B]][e|EC]  2).B[e|EC]; 其中,A、C是整数，B是正整数
有A的话,有没有B都可以
没有A的话, 必须有B
*/
class Solution {
    //扫描字符串时的索引
    int i=0;
    public boolean isNumber(String s) {
        //input check
        if(s==null || s.length()==0)
            return false;
        //去掉首尾的空字符
        s = s.trim();
        boolean A = scanInteger(s), B=false, C=false;
        //判断是否有B; 使用索引时要确保索引不越界
        if(i<s.length() && s.charAt(i)=='.'){
            i++;
            B = scanUnsignedInteger(s);
        }
        //判断是否有C
        if(i<s.length() && (s.charAt(i)=='e' || s.charAt(i)=='E')){
            i++;
            C = scanInteger(s);
            //如果存在e|E, 但是没有C, 说明不是数字
            if(C==false)
                return false;
        }
        //here, 说明C是合格的, 只需判断A和B的情况
        //i必须扫描完整个字符串 && (A合格则B合不合格都可以, A不合格则B必须合格)
        return i==s.length() && (A || B);

    }
    private boolean scanInteger(String s){
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-'))
            i++;
        return scanUnsignedInteger(s);
    }
    private boolean scanUnsignedInteger(String s){
        //起始索引
        int start = i;
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        //i>start说明扫描到了数字;
        //i<=start说明没有扫描到数字, 此种情况说明要么start越界, 要么s.charAt(start)不是数字
        return i > start;
    }
}