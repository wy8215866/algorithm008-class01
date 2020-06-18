class Solution {
    public int n;
    public int m;
    class UnionFind {
        public int count = 0;
        public int[] parent;

        public UnionFind(char[][] grid) {
            for(int i =0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(grid[i][j]=='1') count ++;
                }
            }
            parent = new int[n*m];
            for(int i = 0;i<n*m;i++){
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        n = grid.length;
        m = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]=='0') continue;
                int p = i*m + j;
                int q;
                if(i>0&&grid[i-1][j]=='1'){
                    q = p-m;
                    uf.union(p,q);
                }
                if(i<n-1&&grid[i+1][j]=='1'){
                    q = p + m;
                    uf.union(p,q);
                }
                if(j>0&&grid[i][j-1]=='1'){
                    q = p - 1;
                    uf.union(p,q);
                }
                if(j<m-1&&grid[i][j+1]=='1'){
                    q = p + 1;
                    uf.union(p,q);
                }
            }
        }
        return uf.count;
    }
}


