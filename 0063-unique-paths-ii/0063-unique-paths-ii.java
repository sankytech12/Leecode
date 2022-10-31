class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int dp[][]=new int [grid.length][grid[0].length];
    for(int i[]:dp){
        Arrays.fill(i, -1);
    }
    int ans=paths(grid,0,0,dp);
  return ans;
  }

private static int paths(int[][] grid,int i,int j,int [][]dp) {
    if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
    if (grid[i][j]==1) return 0;
    if(i==grid.length-1 && j==grid[0].length-1) return 1;
    if(dp[i][j]!=-1) return dp[i][j];
    int right=0,down=0;
    right+=paths(grid, i, j+1,dp);
    down+=paths(grid, i+1, j,dp);
    return dp[i][j]=right+down;
}
}