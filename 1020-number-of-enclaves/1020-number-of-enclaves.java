class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int [][]vis=new int[n][m];
        int []dr={0,0,1,-1};
        int []dc={1,-1,0,0};
        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && vis[0][i]==0){
                dfs(grid,vis,dr,dc,0,i);
            }
            if(grid[n-1][i]==1 && vis[n-1][i]==0){
                dfs(grid,vis,dr,dc,n-1,i);
            }
        }
        for(int j=0;j<n;j++){
            if(grid[j][0]==1 && vis[j][0]==0){
                dfs(grid,vis,dr,dc,j,0);
            }
            if(grid[j][m-1]==1 && vis[j][m-1]==0){
                dfs(grid,vis,dr,dc,j,m-1);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int [][]grid,int [][]vis,int dr[],int dc[],int row,int col){
        vis[row][col]=1;
        int n=grid.length,m=grid[0].length;
        for(int i=0;i<dr.length;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0){
                dfs(grid,vis,dr,dc,nr,nc);
            }
        }
    }
}