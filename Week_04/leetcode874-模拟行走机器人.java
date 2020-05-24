import java.util.HashSet;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Object> set = new HashSet<>();
        for(int[] obs:obstacles){
            set.add(obs[0] +" " +obs[1]);
        }
        int d = 0;int x = 0;int y = 0;int res = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int c:commands){
            if(c==-1){
                d++;
                if (d == 4) {
                    d = 0;
                }
            }else if(c==-2){
                d--;
                if (d == -1) {
                    d = 3;
                }
            }else{
                while(c-->0&&!set.contains((x+dirs[d][0])+" "+(y+dirs[d][1]))){
                    x+=dirs[d][0];
                    y+=dirs[d][1];
                }
            }
            res = Math.max(res,x*x+y*y);
        }
        return res;
    }
}

