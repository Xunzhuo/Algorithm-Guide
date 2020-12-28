class Solution {
    static int[][] check ;
    static char[] arr;

    public static void main(String[] args) {
        char[][] board = {{'a','b'}};
        System.out.println(exist(board, "ba"));
    }
    public static boolean exist(char[][] board, String word) {
        check = new int[board.length][board[0].length];
        arr = word.toCharArray();
        int index = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                index = 0;
                for(int k=0; k<check.length; k++)
                    Arrays.fill(check[k], 0);  //初始化check
                check[i][j] = 1;
                if( dfs(board, i, j, index) )
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int index) {
        if(index>=arr.length) return true;   //递归出口
        if(board[i][j]!=arr[index]) return false;
        //boolean f1 = false, f2 = false, f3 = false, f4 = false;

        //向上走
        if(i-1>=0 && check[i-1][j]==0){
            check[i-1][j] = 1;
            if( dfs(board, i-1, j, index+1) )
                return true;     //已经找到路径，就没有必要再进行其他方向的搜索
            check[i-1][j] = 0;  //回溯
        }

        //向下走
        if(i+1<board.length && check[i+1][j]==0){
            check[i+1][j] = 1;
            if(dfs(board, i+1, j, index+1))
                return true;
            check[i+1][j] = 0;
        }

        //向左走
        if(j-1>=0 && check[i][j-1]==0){
            check[i][j-1] = 1;
            if(dfs(board, i, j-1, index+1))
                return true;
            check[i][j-1] = 0;
        }

        //向右走
        if(j+1<board[0].length && check[i][j+1]==0){
            check[i][j+1] = 1;
            if(dfs(board, i, j+1, index+1))
                return true;
            check[i][j+1] = 0;
        }

        if(index==arr.length-1){//已经找到路径
            return true;
        }
        return false;
    }
}