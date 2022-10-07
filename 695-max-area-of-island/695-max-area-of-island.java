class Solution {
    static int count;
    public int maxAreaOfIsland(int[][] grid) {
     int [][]vis=new int[grid.length][grid[0].length];
       
		int ans=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==1 && vis[i][j]==0) {
					//count++;
                     count=0;
					dfs(grid,i,j,vis);
                    ans=Math.max(count,ans);
				}
			}
		}
		return ans;
    }
    private static void dfs(int[][] grid, int i, int j, int[][] vis) {
		// TODO Auto-generated method stub
		vis[i][j]=1;
        count++;
        int r[]={0,1,0,-1};
        int c[]={1,0,-1,0};
		    for(int k=0;k<r.length;k++){
                
				int nr=r[k]+i;
				int nc=c[k]+j;
				if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && vis[nr][nc]==0) {
					dfs(grid, nr, nc, vis);
				}
			
		}
		
	}
        
}