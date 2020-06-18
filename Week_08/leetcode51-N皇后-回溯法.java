import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        dfs(board,0);
        return res;
    }

    public void dfs(char[][] board,int col){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int i = 0;i<board.length;i++){
            if(validate(board,i,col)){
                board[i][col] = 'Q';
                dfs(board,col+1);
                board[i][col] = '.';
            }
        }
    }

    public boolean validate(char[][] board,int x,int y){
        for(int i = 0;i<board.length;i++){
            for(int j =0;j<y;j++){
                if(board[i][j] == 'Q'&&(x+j==y+i||x+y==i+j||x==i))
                    return false;
            }
        }
        return true;
    }


    public List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i = 0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


}


