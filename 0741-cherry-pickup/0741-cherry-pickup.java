class Solution {
    public int cherryPickup(int[][] grid) {
        
     int n=grid.length;
        Integer [][][][]dp=new Integer[n][n][n][n];
        int ans=solve(grid,0,0,0,0,grid.length,dp);
        return ans<0?0:ans;
    }

    private static int solve(int[][] grid, int i1,int j1, int i2, int j2,int n,Integer [][][][]dp) {
        if(i1>=n || i2>=n || j1>=n || j2>=n || grid[i1][j1]==-1 || grid[i2][j2]==-1){
            return (int)(-1e7);
        }
        if(i1==n-1 && j1==n-1){
            return grid[i1][j1];
        }
        if(i2==n-1 && j2==n-1){
            return grid[i2][j2];
        }
        if(dp[i1][j1][i2][j2]!=null) return dp[i1][j1][i2][j2];
       int cherry;
        if(i1==i2 && j1==j2){
            cherry=grid[i1][j1];
        }
        else cherry=grid[i1][j1]+grid[i2][j2];

        cherry+=Math.max(
            Math.max(solve(grid, i1+1, j1, i2+1, j2,n,dp), solve(grid, i1+1, j1, i2, j2+1,n,dp)), 
        Math.max(solve(grid, i1, j1+1, i2+1, j2,n,dp), solve(grid, i1, j1+1, i2, j2+1,n,dp)));
        return dp[i1][j1][i2][j2]=cherry;

    }
}