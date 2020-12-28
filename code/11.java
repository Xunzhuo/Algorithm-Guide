class Solution {

    static int row, col, K;
    static int[] x = {-1, 0, 1, 0}; //上， 左， 下， 右
    static int[] y = {0, -1, 0, 1};
    //static int[][] count;
    static int[][] grash;

    public static void main(String[] args) {
        System.out.println(movingCount(11,8,16));
    }

    public static int movingCount(int m, int n, int k) {
        row = m;
        col = n;
        K = k;
        grash = new int[m][n];
        //count = new int[m][n];
        grash[0][0] = 1;
        dfs(0, 0);
        int res = 0;
        for(int i=0; i<grash.length; i++){
            for(int j=0; j<grash[0].length; j++){
                res += grash[i][j];
            }
        }
        return res;
    }

    private static void dfs(int i, int j) {
        //count[i][j] = 1;
        for(int t=0; t<4; t++){
            int ex = i + x[t];
            int ey = j + y[t];
            if(ex>=0 && ey>=0 && ex<row && ey<col && check(ex,ey) && grash[ex][ey]==0){
                grash[ex][ey] = 1;
                dfs(ex, ey);
                //grash[ex][ey] = 0;
            }
        }
        return ;
    }

    private static boolean check(int i, int j) {
        int a1 = i%10;   //获取个位上的值
        int a2 = 0;
        if(i>9)
            a2 = i/10%10;   //获取十位上的值
        int b1 = j%10;
        int b2 = 0;
        if(j>9)
            b2 = j/10%10;
        if((a1+a2+b1+b2)<=K)
            return true;
        return false;
    }
}