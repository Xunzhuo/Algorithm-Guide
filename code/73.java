class Solution {
    public int strToInt(String str) {
        str = str.trim();
        if(str.equals("")){
            return 0;
        }
        int n = str.length();
        int p = 0;
        char[] chs = str.toCharArray();
        int res = 0;
        int flag = 1;
        if(chs[p]=='-'){
            flag = -1;
            p++;
        }else if(chs[p]=='+'){
            p++;
        }

        for(; p<n; p++){
            char ch = chs[p];
            if(ch>='0' && ch<='9'){
                //溢出判断
                if(flag==1){
                    //res * 10 + cur > max
                    if(res>(Integer.MAX_VALUE - (ch-'0'))/10){
                        return Integer.MAX_VALUE;
                    }
                }else{
                    //-res * 10 - cur < min
                    if(-res<(Integer.MIN_VALUE + ch - '0')/10){
                        return Integer.MIN_VALUE;
                    }
                }
                res = res*10 + ch - '0';
            }else{
                break;
            }
        }
        return res*flag;

    }
}